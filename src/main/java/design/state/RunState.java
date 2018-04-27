package design.state;

/**
 * @author renzhiyong
 * @description:
 * @date 2018-04-27 19:29
 */
public class RunState extends LiftState {
    public RunState(LiftContext context) {
        super(context);
    }

    @Override
    void close() {
        System.out.println("already closed ...");
    }

    @Override
    void open() {
        System.out.println("cannt open ...");
    }

    @Override
    void run() {
        System.out.println("already run ...");
    }

    @Override
    void stop() {
        super.context.setLiftState(context.stopState);
        System.out.println("stoping ...");
    }
}
