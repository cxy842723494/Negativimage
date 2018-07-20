package com.example.xch.negativimage;

import android.content.Context;
import android.graphics.Bitmap;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;

public class BlurHandle {

    public static Bitmap blurhandle (Context context, Bitmap bitmap, int radius){

        RenderScript renderScript = RenderScript.create(context);
        Allocation in = Allocation.createFromBitmap(renderScript, bitmap);
        Allocation out = Allocation.createTyped(renderScript, in.getType());
        ScriptIntrinsicBlur scriptIntrinsicBlur = ScriptIntrinsicBlur.create(renderScript, Element.U8_4(renderScript));
        scriptIntrinsicBlur.setRadius(radius);
        scriptIntrinsicBlur.setInput(in);
        scriptIntrinsicBlur.forEach(out);
        out.copyTo(bitmap);

        renderScript.destroy();
        in.destroy();
        out.destroy();

        return bitmap;


    }
}
