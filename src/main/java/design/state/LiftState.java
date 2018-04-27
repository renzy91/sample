package design.state;

/**
 * @author renzhiyong
 * @description:
 * @date 2018-04-27 17:42
 */
public abstract class LiftState {
    protected LiftContext context;

    public LiftState(LiftContext context) {
        this.context = context;
    }

    abstract void close();
    abstract void open();
    abstract void run();
    abstract void stop();
}
