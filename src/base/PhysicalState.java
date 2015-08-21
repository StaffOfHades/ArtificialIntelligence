package base;

/**
 * Created by mauriciog on 8/19/15.
 */
public class PhysicalState {

    private int mX, mY, mR, mS;

    public PhysicalState(int xAxis, int yAxis) {
        mX = xAxis;
        mY = yAxis;
        mR = 0;
        mS = 1;
    }

    public PhysicalState(int xAxis, int yAxis, int rotation) {
        mX = xAxis;
        mY = yAxis;
        mR = rotation;
        mS = 1;
    }

    public PhysicalState(int xAxis, int yAxis, int rotation, int size) {
        mX = xAxis;
        mY = yAxis;
        mR = rotation;
        mS = size;
    }

    public void setXAxis(int xAxis) {
        mX = xAxis;
    }

    public void setYAxis(int yAxis) {
        mY = yAxis;
    }

    public void setRotation(int rotation) {
        mR = rotation;
    }

    public void setSize(int size) {
        mS = size;
    }

    public int getXAxis() {
        return mX;
    }

    public int getYAxis() {
        return mY;
    }

    public int getRotation() {
        return mR;
    }

    public int getSize() {
        return mS;
    }


}
