package design.state;

/**
 * @author renzhiyong
 * @description:
 * @date 2018-04-27 17:47
 */
public class CloseState extends LiftState {
    public CloseState(LiftContext context) {
        super(context);
    }

    @Override
    public void close() {
        System.out.println("already closed..");
    }

    @Override
    public void open() {
        super.context.setLiftState(context.openState);
        System.out.println("opening ...");
    }

    @Override
    public void run() {
        super.context.setLiftState(context.runState);
        System.out.println("running ...");
    }

    @Override
    public void stop() {
        super.context.setLiftState(context.stopState);
        System.out.println("stoping ...");
    }
}
