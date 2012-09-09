package helpers;

public class EmailHelper {

	public static String WriteButtonXml(String startColor, String endColor) {

		StringBuilder sb = new StringBuilder();

		sb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n");
		sb.append("<selector xmlns:android=\"http://schemas.android.com/apk/res/android\">\n");
		sb.append("<item android:state_pressed=\"true\" >\n");
		sb.append("<shape>\n");
		sb.append("<solid \n");
		sb.append("android:color=\"#" + startColor + "\" />\n");
		sb.append("<stroke \n");
		sb.append("android:width=\"1dp\"\n");
		sb.append("android:color=\"#" + endColor + "\" />\n");
		sb.append("<corners \n");
		sb.append("android:radius=\"3dp\" />\n");
		sb.append("<padding \n");
		sb.append("android:left=\"10dp\"\n");
		sb.append("android:top=\"10dp\"\n");
		sb.append("android:right=\"10dp\"\n");
		sb.append("android:bottom=\"10dp\" />\n");
		sb.append("</shape>\n");
		sb.append("</item>\n");
		sb.append("<item>\n");
		sb.append("<shape>\n");
		sb.append("<gradient \n");
		sb.append("android:startColor=\"#" + startColor + "\"\n");
		sb.append("android:endColor=\"#" + endColor + "\"\n");
		sb.append("android:angle=\"270\" />\n");
		sb.append("<stroke \n");
		sb.append("android:width=\"1dp\"\n");
		sb.append("android:color=\"#" + endColor + "\" />\n");
		sb.append("<corners \n");
		sb.append("android:radius=\"4dp\" />\n");
		sb.append("<padding \n");
		sb.append("android:left=\"10dp\"\n");
		sb.append("android:top=\"10dp\"\n");
		sb.append("android:right=\"10dp\"\n");
		sb.append("android:bottom=\"10dp\" />\n");
		sb.append("</shape>\n");
		sb.append("</item>\n");
		sb.append("</selector>\n");
		
		return sb.toString();

	}

}
