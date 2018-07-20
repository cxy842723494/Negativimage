package com.example.xch.negativimage;

import android.content.Context;
import android.graphics.Bitmap;
import android.renderscript.Allocation;
import android.renderscript.RenderScript;

public class NegativeHandle {

    public static Bitmap negativehandle(Bitmap bitmap, Context context){

        RenderScript renderScript = RenderScript.create(context);
        ScriptC_foo sketchScript = new ScriptC_foo(renderScript);

        Allocation in = Allocation.createFromBitmap(renderScript, bitmap);
        Allocation out = Allocation.createTyped(renderScript, in.getType());

        sketchScript.forEach_invert(in,out);

        out.copyTo(bitmap);

        renderScript.destroy();
        sketchScript.destroy();
        in.destroy();
        out.destroy();

        return bitmap;
    }

}
