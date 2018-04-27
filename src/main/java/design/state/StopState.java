package design.state;

/**
 * @author renzhiyong
 * @description:
 * @date 2018-04-27 19:29
 */
public class StopState extends LiftState {
    public StopState(LiftContext context) {
        super(context);
    }

    @Override
    void close() {
        super.context.setLiftState(context.closeState);
        System.out.println("closing ...");
    }

    @Override
    void open() {
        super.context.setLiftState(context.openState);
        System.out.println("opening ...");
    }

    @Override
    void run() {
        super.context.setLiftState(context.runState);
        System.out.println("running ...");
    }

    @Override
    void stop() {
        System.out.println("already stop ...");
    }
}
