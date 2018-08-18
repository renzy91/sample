package tcpip;

import org.jnetpcap.Pcap;
import org.jnetpcap.PcapIf;
import org.jnetpcap.packet.JPacket;
import org.jnetpcap.packet.PcapPacket;
import org.jnetpcap.packet.PcapPacketHandler;
import org.jnetpcap.protocol.lan.Ethernet;
import org.jnetpcap.protocol.network.Arp;
import org.jnetpcap.protocol.network.Ip4;
import org.jnetpcap.protocol.tcpip.Http;
import org.jnetpcap.protocol.tcpip.Tcp;
import org.jnetpcap.protocol.tcpip.Udp;
import org.jnetpcap.util.JNetPcapFormatter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author renzhiyong
 * @description:
 * @date 2018-08-09 10:56
 */
public class Arp1 {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() + 1);

        ArrayList<PcapIf> allDevs = new ArrayList<>();
        StringBuilder errbuf = new StringBuilder();
        int i = Pcap.findAllDevs(allDevs, errbuf);
        if (i == -1 || allDevs.isEmpty()) {
            System.out.println("find devices fail: " + errbuf.toString());
        }

//        PcapIf device = allDevs.get(0);
        PcapIf device = allDevs.get(2);
        Pcap pcap = Pcap.openLive(device.getName(), 65536, Pcap.MODE_PROMISCUOUS, 10000, errbuf);

        byte[] sendMac = {(byte)0xf4,(byte)0xe1,(byte)0xad,0x13,0x18,0x19};
        byte[] sendIP = {(byte)192,(byte)168,(byte)250,(byte)1};

        PcapPacketHandler handler = (packet, o) -> {
            Ip4 ip = packet.getHeader(new Ip4());
            Ethernet ethernet = packet.getHeader(new Ethernet());
            Arp arp = packet.getHeader(new Arp());

            if (arp == null || ethernet == null) {
                return;
            }

//            /** hardware size */
//            System.out.println(arp.hlen());
//            /** protocol size */
//            System.out.println(arp.plen());
//            /** sender MAC */
//            System.out.println(Arrays.toString(arp.sha()));
//            /** sender IP */
//            System.out.println(Arrays.toString(arp.spa()));
//            /** target MAC */
//            System.out.println(Arrays.toString(arp.tha()));
//            /** target IP */
//            System.out.println(Arrays.toString(arp.tpa()));
//            /** op code */
//            System.out.println(arp.operation());

            //request
            if (arp.operation() == 1 && Arrays.equals(arp.spa(), sendIP)) {
                executorService.submit(() -> {
                    JPacket arpPacket = ArpPacket.createArp(sendMac, arp.tpa(), arp.sha(), arp.spa());
                    int r = pcap.sendPacket(arpPacket);
                    if (r != Pcap.OK) {
                        System.out.println("send error");
                    }
                    System.out.println("send arp replay");
                });
            }
        };

        /*while (true) {
            pcap.loop(1000, handler, "test");
        }*/

        while (true) {
//            JPacket arpPacket = ArpPacket.createArp("f4963405d882", "c0a8fa01", "a471748bf4c4", "c0a8fb36");
//            JPacket arpPacket = ArpPacket.createArp("f4963405d882", "c0a8fa01", "f4963405d881", "c0a8fa77");
            JPacket arpPacket = ArpPacket.createArp("f4963405d882", "0a0a1401", "54e1ad07c476", "0a0a15f5");
            System.out.println(arpPacket);
            int r = pcap.sendPacket(arpPacket);
            if (r != Pcap.OK) {
                System.out.println("send error");
            }
            System.out.println("send arp replay");
            Thread.sleep(1000);
        }

//        pcap.close();
    }
}
