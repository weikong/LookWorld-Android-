package com.look.world.until;

import android.content.Context;
import android.content.res.Resources;

import com.look.world.R;


/**
 * Created by xinzhendi-031 on 2017/9/27.
 */
public class ADFilterTool {
    public static String getClearAdDivJs(Context context) {
        String js = "javascript:";
        Resources res = context.getResources();
        String[] adDivs = res.getStringArray(R.array.adBlockDiv);
        for (int i = 0; i < adDivs.length; i++) {
            js += "var adDiv" + i + "= document.getElementById('" + adDivs[i] + "');if(adDiv" + i + " != null)adDiv" + i + ".parentNode.removeChild(adDiv" + i + ");";
        }
        return js;
    }
}
