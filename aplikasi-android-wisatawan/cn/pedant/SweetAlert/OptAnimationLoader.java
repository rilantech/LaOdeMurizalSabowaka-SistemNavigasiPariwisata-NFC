package cn.pedant.SweetAlert;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.util.Xml;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class OptAnimationLoader {
    public static Animation loadAnimation(Context context, int id) throws Resources.NotFoundException {
        XmlResourceParser parser = null;
        try {
            XmlResourceParser parser2 = context.getResources().getAnimation(id);
            Animation createAnimationFromXml = createAnimationFromXml(context, parser2);
            if (parser2 != null) {
                parser2.close();
            }
            return createAnimationFromXml;
        } catch (XmlPullParserException ex) {
            Resources.NotFoundException rnf = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(id));
            rnf.initCause(ex);
            throw rnf;
        } catch (IOException ex2) {
            Resources.NotFoundException rnf2 = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(id));
            rnf2.initCause(ex2);
            throw rnf2;
        } catch (Throwable th) {
            if (parser != null) {
                parser.close();
            }
            throw th;
        }
    }

    private static Animation createAnimationFromXml(Context c, XmlPullParser parser) throws XmlPullParserException, IOException {
        return createAnimationFromXml(c, parser, (AnimationSet) null, Xml.asAttributeSet(parser));
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0056, code lost:
        if (r6.equals("rotate") != false) goto L_0x005a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.view.animation.Animation createAnimationFromXml(android.content.Context r9, org.xmlpull.v1.XmlPullParser r10, android.view.animation.AnimationSet r11, android.util.AttributeSet r12) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            r0 = 0
            int r1 = r10.getDepth()
        L_0x0005:
            int r2 = r10.next()
            r3 = r2
            r4 = 3
            if (r2 != r4) goto L_0x0013
            int r2 = r10.getDepth()
            if (r2 <= r1) goto L_0x00d8
        L_0x0013:
            r2 = 1
            if (r3 == r2) goto L_0x00d8
            r5 = 2
            if (r3 == r5) goto L_0x001a
            goto L_0x0005
        L_0x001a:
            java.lang.String r6 = r10.getName()
            int r7 = r6.hashCode()
            r8 = 0
            switch(r7) {
                case -925180581: goto L_0x0050;
                case 113762: goto L_0x0046;
                case 92909918: goto L_0x003c;
                case 109250890: goto L_0x0032;
                case 1052832078: goto L_0x0027;
                default: goto L_0x0026;
            }
        L_0x0026:
            goto L_0x0059
        L_0x0027:
            java.lang.String r4 = "translate"
            boolean r4 = r6.equals(r4)
            if (r4 == 0) goto L_0x0026
            r4 = 4
            goto L_0x005a
        L_0x0032:
            java.lang.String r4 = "scale"
            boolean r4 = r6.equals(r4)
            if (r4 == 0) goto L_0x0026
            r4 = r5
            goto L_0x005a
        L_0x003c:
            java.lang.String r4 = "alpha"
            boolean r4 = r6.equals(r4)
            if (r4 == 0) goto L_0x0026
            r4 = r2
            goto L_0x005a
        L_0x0046:
            java.lang.String r4 = "set"
            boolean r4 = r6.equals(r4)
            if (r4 == 0) goto L_0x0026
            r4 = r8
            goto L_0x005a
        L_0x0050:
            java.lang.String r7 = "rotate"
            boolean r7 = r6.equals(r7)
            if (r7 == 0) goto L_0x0026
            goto L_0x005a
        L_0x0059:
            r4 = -1
        L_0x005a:
            switch(r4) {
                case 0: goto L_0x007e;
                case 1: goto L_0x0077;
                case 2: goto L_0x0070;
                case 3: goto L_0x0069;
                case 4: goto L_0x0062;
                default: goto L_0x005d;
            }
        L_0x005d:
            java.lang.Class r4 = java.lang.Class.forName(r6)     // Catch:{ Exception -> 0x00ac }
            goto L_0x008b
        L_0x0062:
            android.view.animation.TranslateAnimation r2 = new android.view.animation.TranslateAnimation
            r2.<init>(r9, r12)
            r0 = r2
            goto L_0x00a5
        L_0x0069:
            android.view.animation.RotateAnimation r2 = new android.view.animation.RotateAnimation
            r2.<init>(r9, r12)
            r0 = r2
            goto L_0x00a5
        L_0x0070:
            android.view.animation.ScaleAnimation r2 = new android.view.animation.ScaleAnimation
            r2.<init>(r9, r12)
            r0 = r2
            goto L_0x00a5
        L_0x0077:
            android.view.animation.AlphaAnimation r2 = new android.view.animation.AlphaAnimation
            r2.<init>(r9, r12)
            r0 = r2
            goto L_0x00a5
        L_0x007e:
            android.view.animation.AnimationSet r2 = new android.view.animation.AnimationSet
            r2.<init>(r9, r12)
            r0 = r2
            r2 = r0
            android.view.animation.AnimationSet r2 = (android.view.animation.AnimationSet) r2
            createAnimationFromXml(r9, r10, r2, r12)
            goto L_0x00a5
        L_0x008b:
            java.lang.Class[] r5 = new java.lang.Class[r5]     // Catch:{ Exception -> 0x00ac }
            java.lang.Class<android.content.Context> r7 = android.content.Context.class
            r5[r8] = r7     // Catch:{ Exception -> 0x00ac }
            java.lang.Class<android.util.AttributeSet> r7 = android.util.AttributeSet.class
            r5[r2] = r7     // Catch:{ Exception -> 0x00ac }
            java.lang.reflect.Constructor r2 = r4.getConstructor(r5)     // Catch:{ Exception -> 0x00ac }
            java.lang.Object[] r4 = new java.lang.Object[]{r9, r12}     // Catch:{ Exception -> 0x00ac }
            java.lang.Object r2 = r2.newInstance(r4)     // Catch:{ Exception -> 0x00ac }
            android.view.animation.Animation r2 = (android.view.animation.Animation) r2     // Catch:{ Exception -> 0x00ac }
            r0 = r2
        L_0x00a5:
            if (r11 == 0) goto L_0x00aa
            r11.addAnimation(r0)
        L_0x00aa:
            goto L_0x0005
        L_0x00ac:
            r2 = move-exception
            java.lang.RuntimeException r4 = new java.lang.RuntimeException
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r7 = "Unknown animation name: "
            java.lang.StringBuilder r5 = r5.append(r7)
            java.lang.String r7 = r10.getName()
            java.lang.StringBuilder r5 = r5.append(r7)
            java.lang.String r7 = " error:"
            java.lang.StringBuilder r5 = r5.append(r7)
            java.lang.String r7 = r2.getMessage()
            java.lang.StringBuilder r5 = r5.append(r7)
            java.lang.String r5 = r5.toString()
            r4.<init>(r5)
            throw r4
        L_0x00d8:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.pedant.SweetAlert.OptAnimationLoader.createAnimationFromXml(android.content.Context, org.xmlpull.v1.XmlPullParser, android.view.animation.AnimationSet, android.util.AttributeSet):android.view.animation.Animation");
    }
}
