package lzf.recycler.demo;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;

/**
 * Created by Administrator on 2016/11/23 0023.
 */
public class AnimatorUtils {
    /**
     * 属性动画PropertyAni
     * <p>
     * 常用的属性动画的属性值有：
     * - translationX、translationY----控制view对象相对其左上角坐标在X、Y轴上偏移的距离
     * - rotation、rotationX、rotationY----控制view对象绕支点进行2D和3D旋转
     * - scaleX、scaleY----控制view对象绕支点进行2D缩放
     * - pivotX、pivotY----控制view对象的支点位置，这个位置一般就是view对象的中心点。围绕这个支点可以进行旋转和缩放处理
     * - x、y----描述view对象在容器中的最终位置，是最初的左上角坐标和translationX、translationY值的累计和
     * - alpha----表示view对象的透明度。默认值是1(完全透明)、0(不透明)
     * <p>
     */
    //位移
    public static void translate(View view,float distance,long duration){
        ObjectAnimator animator = ObjectAnimator.ofFloat(
                view,
                "translationY",
                distance);
        animator.setDuration(duration);
        animator.start();
    }
    public static void scale(View view,float scale,long duration){
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(
                view,
                "scaleX",
                scale);
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(
                view,
                "scaleY",
                scale);
        ObjectAnimator animator3 = null;
        if (scale!=0) {
            animator3 = ObjectAnimator.ofFloat(
                    view,
                    "translationY",
                    250);
        }else {
            animator3 = ObjectAnimator.ofFloat(
                    view,
                    "translationY",
                    0);
        }
        AnimatorSet aniSet = new AnimatorSet();
        aniSet.setDuration(duration);
        aniSet.playTogether(animator1,animator2,animator3);
        aniSet.start();
    }
    public static void scale2(View view,float scale){
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(
                view,
                "scaleX",
                scale);
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(
                view,
                "scaleY",
                scale);
        AnimatorSet aniSet = new AnimatorSet();
        aniSet.setDuration(1000);
        aniSet.playTogether(animator1,animator2);
        aniSet.start();
    }
    public static void translate(View view, float fromX, float fromY, float toX, float toY) {
        if (toX!=0||toY!=0) {
            ObjectAnimator animator1 = ObjectAnimator.ofFloat(
                    view,
                    "y",
                    fromY,
                    toY);
            ObjectAnimator animator2 = ObjectAnimator.ofFloat(
                    view,
                    "x",
                    fromX,
                    toX);
            AnimatorSet aniSet = new AnimatorSet();
            aniSet.setDuration(0);
            aniSet.playTogether(animator1,animator2);
            aniSet.start();
        }
    }

    public static void rotation(View view, float fromRotation, float toRotation){
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(
                view,
                "rotation",
                fromRotation,
                toRotation);
        animator1.setDuration(0);
        animator1.start();
    }
    public static void scale(View view, float fromScaleX, float toScaleX, float fromScaleY, float toScaleY) {
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(
                view,
                "scaleX",
                fromScaleX,
                toScaleX);
        ObjectAnimator animator3 = ObjectAnimator.ofFloat(
                view,
                "scaleY",
                fromScaleY,
                toScaleY);
        AnimatorSet aniSet = new AnimatorSet();
        aniSet.setDuration(0);
        aniSet.playTogether(animator2, animator3);
        aniSet.start();
    }
}
