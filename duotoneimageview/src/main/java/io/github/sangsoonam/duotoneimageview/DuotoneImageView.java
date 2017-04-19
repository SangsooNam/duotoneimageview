package io.github.sangsoonam.duotoneimageview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.support.annotation.ColorInt;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

/**
 * ImageView for duotone. This class applies a duotone color filter based on
 * {@code colorWhite, colorBlack, contrast} attributes.
 */
public class DuotoneImageView extends AppCompatImageView {

    private int mColorWhite;
    private int mColorBlack;
    private float mContrast;

    public DuotoneImageView(Context context) {
        this(context, null);
    }

    public DuotoneImageView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DuotoneImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray attributes = context.obtainStyledAttributes(attrs, R.styleable.DuotoneImageView);
        mColorWhite = attributes.getColor(R.styleable.DuotoneImageView_colorWhite, Color.WHITE);
        mColorBlack = attributes.getColor(R.styleable.DuotoneImageView_colorBlack, Color.BLACK);
        mContrast = attributes.getFloat(R.styleable.DuotoneImageView_contrast, 1);
        attributes.recycle();

        setDuotoneColorFilter(mColorWhite, mColorBlack, mContrast);
    }

    @ColorInt
    public int getColorBlack() {
        return mColorBlack;
    }

    @ColorInt
    public int getColorWhite() {
        return mColorWhite;
    }

    public float getContrast() {
        return mContrast;
    }

    /**
     * Set duotone color filter. This is used in the constructor and can be used later time also.
     * @param colorWhite color white
     * @param colorBlack color black
     * @param contrast contrast
     */
    public void setDuotoneColorFilter(@ColorInt int colorWhite, @ColorInt int colorBlack, float contrast) {
        ColorMatrix colorMatrix = new ColorMatrix();

        // Create a black and white image
        colorMatrix.postConcat(setBlackAndWhite(new ColorMatrix()));

        // Give a contrast
        colorMatrix.postConcat(setContrast(new ColorMatrix(), contrast));

        // Set a duotone
        colorMatrix.postConcat(setDuotone(new ColorMatrix(), colorWhite, colorBlack));
        setColorFilter(new ColorMatrixColorFilter(colorMatrix));
    }

    private static ColorMatrix setBlackAndWhite(ColorMatrix cm) {
        cm.set(new float[]{
            0.33f, 0.33f, 0.33f, 0, 0,
            0.33f, 0.33f, 0.33f, 0, 0,
            0.33f, 0.33f, 0.33f, 0, 0,
            0,     0,     0,     1, 0
        });
        return cm;
    }


    private static ColorMatrix setContrast(ColorMatrix cm, float contrast) {
        float scale = contrast + 1.0f;
        float translate = (-0.5f * scale + 0.5f) * 255.0f;
        cm.set(new float[] {
            scale, 0, 0, 0, translate,
            0, scale, 0, 0, translate,
            0, 0, scale, 0, translate,
            0, 0, 0, 1, 0
        });
        return cm;
    }

    private static ColorMatrix setDuotone(ColorMatrix cm, @ColorInt int colorWhite, @ColorInt int colorBlack) {
        float whiteR = Color.red(colorWhite);
        float whiteG = Color.green(colorWhite);
        float whiteB = Color.blue(colorWhite);

        float blackR = Color.red(colorBlack);
        float blackG = Color.green(colorBlack);
        float blackB = Color.blue(colorBlack);

        float r = (whiteR - blackR) / 255.0f;
        float g = (whiteG - blackG) / 255.0f;
        float b = (whiteB - blackB) / 255.0f;
        cm.set(new float[] {
            r, 0, 0, 0, blackR,
            g, 0, 0, 0, blackG,
            b, 0, 0, 0, blackB,
            0, 0, 0, 1, 0
        });
        return cm;
    }
}
