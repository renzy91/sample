package tcpip;

import org.jnetpcap.packet.JMemoryPacket;
import org.jnetpcap.packet.JPacket;
import org.jnetpcap.protocol.JProtocol;

/**
 * @author renzhiyong
 * @description:
 * @date 2018-08-09 15:25
 */
public class ArpPacket {
    private static final String HARDWARETYPE = "0001";
    private static final String PROTOCOLTYPE = "0800";
    private static final String HARDWARE_SIZE = "06";
    private static final String PROTOCOL_SIZE = "04";
    private static final String OP_CODE = "0002";

    public static JPacket createArp(String sendMac, String sendIp, String targetMac, String targetIp) {
        String packet = String.format("%s%s%s%s%s%s%s%s%s", HARDWARETYPE, PROTOCOLTYPE, HARDWARE_SIZE, PROTOCOL_SIZE,
                OP_CODE, sendMac, sendIp, targetMac, targetIp);

        return new JMemoryPacket(JProtocol.ARP_ID, packet);
    }

    public static JPacket createArp(byte[] sendMac, byte[] sendIp, byte[] targetMac, byte[] targetIp) {
        return createArp(byte2HexString(sendMac), byte2HexString(sendIp), byte2HexString(targetMac), byte2HexString(targetIp));
    }

    public static String byte2HexString(byte[] b) {
        StringBuilder sb = new StringBuilder();
        for (byte b1 : b) {
            String str = Integer.toHexString(b1 & 0xff);
            sb.append(str.length() < 2 ? "0" + str : str);
        }

        return sb.toString();
    }
}
