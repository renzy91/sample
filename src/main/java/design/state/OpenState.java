package design.state;

/**
 * @author renzhiyong
 * @description:
 * @date 2018-04-27 19:29
 */
public class OpenState extends LiftState {
    public OpenState(LiftContext context) {
        super(context);
    }

    @Override
    void close() {
        super.context.setLiftState(context.closeState);
        System.out.println("closing ...");
    }

    @Override
    void open() {
        System.out.println("already opened ...");
    }

    @Override
    void run() {
        System.out.println("cannot run ...");
    }

    @Override
    void stop() {
        super.context.setLiftState(context.stopState);
        System.out.println("stoping ...");
    }
}
