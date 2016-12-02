package comps413f.android.flyingandroid;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable.Callback;

/** The flying android. */
public class FlyingAndroid extends Sprite {

    private static final float INITIAL_DY = 50;  // Initial velocity in vertical direction
    private float dy;  // y velocity of the flying android object
    private boolean status = true;
    private int count =0;
    /** Constructor. */
    public FlyingAndroid(Callback callback, Context context) {
        drawable = (AnimationDrawable) context.getResources().getDrawable(R.drawable.flying_android);
        drawable.setCallback(callback);

        dy = 30;
    }

    /** Reset the x, y position of the flying android. */
    public void reset() {
        // Add code here
        // Task 1: Reset the flying android
        // i. Locate it at the center of the arena
        count =0;
        float x = (FlyingAndroidView.arenaWidth - getWidth()) / 10.f;
        float y = (FlyingAndroidView.arenaHeight - getHeight());// / 2.f;

        // ii. Update its position
        setPosition(x, y);

    }

    /** Move the flying android upward.*/
    public void fly() {
        float y = (FlyingAndroidView.arenaHeight - getHeight());
        if (curPos.y >= y && count >=1) {
            curPos.y -= y*0.1;
            status = false;
        }
        count +=1;
    }
    @Override
    /** Move the flying android. */
    public void move() {

        float y = (FlyingAndroidView.arenaHeight - getHeight());
       if(curPos.y > y*0.75 && status == false){

            curPos.y -= (y*0.02);
            updateBounds();

           }     else{
                if(curPos.y <= y) {
                    curPos.y += (y * 0.02);
                if(curPos.y > y){
                    curPos.y =y;}
                }

                updateBounds();
                status = true;

            };


    }

    @Override
    /** Evaluate if the flying android is moving out of the arena, i.e., game end. */
    public boolean isOutOfArena() {
        if (curPos.y < 0)
            return false;
        return false;
    }
}
