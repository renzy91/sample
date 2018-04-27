package design.state;

/**
 * @author renzhiyong
 * @description:
 * @date 2018-04-27 17:44
 */
public class LiftContext {
    LiftState closeState;
    LiftState openState;
    LiftState runState;
    LiftState stopState;


    private LiftState liftState;

    public LiftContext() {
        closeState = new CloseState(this);
        openState = new OpenState(this);
        runState = new RunState(this);
        stopState = new StopState(this);
        this.liftState = stopState;
    }

    public LiftState getLiftState() {
        return liftState;
    }

    public void setLiftState(LiftState liftState) {
        this.liftState = liftState;
    }

    public void stop() {
        liftState.stop();
    }

    public void open() {
        liftState.open();
    }

    public void close() {
        liftState.close();
    }

    public void run() {
        liftState.run();
    }

}
