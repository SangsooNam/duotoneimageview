## DuotoneImageView
This is a custom imagee view to show a duotone image. Two colors can be defined with `colorWhite`, `colorBlack` and `contrast` attributes in XML.

![Screenshot](https://github.com/SangsooNam/duotoneimageview/blob/master/screenshot/image.png =500x)

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

## License
```
MIT License

Copyright (c) 2017 Sangsoo Nam

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
