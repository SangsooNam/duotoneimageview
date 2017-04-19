package io.github.sangsoonam.duotoneimageview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.res.ResourcePath;
import org.robolectric.res.ResourceTableFactory;
import org.robolectric.res.RoutingResourceTable;

import static junit.framework.Assert.assertEquals;

@RunWith(RobolectricTestRunner.class)
public class DuotoneImageViewTest {

	private final Context mContext = RuntimeEnvironment.application;

	@Before
	public void setUp() throws Exception {
		RuntimeEnvironment.setCompileTimeResourceTable(new RoutingResourceTable(
			new ResourceTableFactory().newResourceTable(getClass().getPackage().getName(), new ResourcePath(R.class, null, null))
		));
	}

	@Test
	public void testStyledAttributes() throws Exception {
		AttributeSet attributeSet = Robolectric.buildAttributeSet()
			.addAttribute(R.attr.colorWhite, "#AAAAAA")
			.addAttribute(R.attr.colorBlack, "#BBBBBB")
			.addAttribute(R.attr.contrast, "0.5")
			.build();

		TypedArray typedArray = mContext.obtainStyledAttributes(attributeSet, R.styleable.DuotoneImageView);
		assertEquals(Color.parseColor("#AAAAAA"), typedArray.getColor(R.styleable.DuotoneImageView_colorWhite, 0));
		assertEquals(Color.parseColor("#BBBBBB"), typedArray.getColor(R.styleable.DuotoneImageView_colorBlack, 0));
		assertEquals(0.5f, typedArray.getFloat(R.styleable.DuotoneImageView_contrast, 0));
		typedArray.recycle();
	}

	@Test
	public void testConstructor() throws Exception {
		AttributeSet attributeSet = Robolectric.buildAttributeSet()
			.addAttribute(R.attr.colorWhite, "#AAAAAA")
			.addAttribute(R.attr.colorBlack, "#BBBBBB")
			.addAttribute(R.attr.contrast, "0.5")
			.build();

		DuotoneImageView duotoneImageView = new DuotoneImageView(mContext, attributeSet);
		assertEquals(Color.parseColor("#AAAAAA"), duotoneImageView.getColorWhite());
		assertEquals(Color.parseColor("#BBBBBB"), duotoneImageView.getColorBlack());
		assertEquals(0.5f, duotoneImageView.getContrast());
	}

	@Test
	public void testConstructorWithNoAttributes() throws Exception {
		DuotoneImageView duotoneImageView = new DuotoneImageView(mContext);
		assertEquals(ContextCompat.getColor(mContext, android.R.color.white), duotoneImageView.getColorWhite());
		assertEquals(ContextCompat.getColor(mContext, android.R.color.black), duotoneImageView.getColorBlack());
		assertEquals(1.0f, duotoneImageView.getContrast());
	}
}