## DuotoneImageView
This is a custom imagee view to show a duotone image. Two colors can be defined with `colorWhite`, `colorBlack` and `contrast` attributes in XML.



```xml
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:orientation="vertical"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@color/colorBlack">

    <ImageView
        android:id="@+id/image1"
        android:layout_width="match_parent"
        android:layout_height="0dp"
        android:layout_weight="1"/>

    <io.github.sangsoonam.duotoneimageview.DuotoneImageView
        android:id="@+id/image2"
        app:colorWhite="@color/colorPrimary"
        app:colorBlack="@color/colorAccent"
        app:contrast="1"
        android:layout_width="match_parent"
        android:layout_height="0dp"
        android:layout_weight="1"/>

</LinearLayout>
```

If you want to set two colors in the code, you can utilize a `setDuotoneColorFilter` method.
```java
/**
 * Set duotone color filter. This is used in the constructor and can be used later time also.
 * @param colorWhite color white
 * @param colorBlack color black
 * @param contrast contrast
 */
public void setDuotoneColorFilter(@ColorInt int colorWhite, @ColorInt int colorBlack, float contrast)
```
