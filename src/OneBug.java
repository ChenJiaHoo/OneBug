import java.io.*;
        import java.net.HttpURLConnection;
        import java.net.URL;

public class OneBug {
    public OneBug(String a) throws IOException {
        String path="C:\\Users\\asus\\Desktop\\OneBug.txt";
        File file=new File(path);
        if(!file.exists()){
            file.getParentFile().mkdir();
        }
        file.createNewFile();
        FileWriter fw=new FileWriter(file,true);
        BufferedWriter bw=new BufferedWriter(fw);
        bw.write(a);
        bw.flush();
        bw.close();
        //
        FileReader fr=new FileReader(file);
        BufferedReader br=new BufferedReader(fr);
        String str=br.readLine();
    }
    public static void main(String[]args){
        String r;
        try {
            URL url=new URL("https://www.sina.com.cn");
            System.out.println("Start------>:"+url);
            HttpURLConnection urlConnection=(HttpURLConnection)url.openConnection();
            int responseCode=urlConnection.getResponseCode();
            if (responseCode==200){
                BufferedReader reader=new BufferedReader(new InputStreamReader(urlConnection.getInputStream(),"utf-8"));
                while ((r=reader.readLine())!=null){
                    System.out.println(r);
                    new OneBug(r);
                }
            }else {
                System.out.println("获取不到源代码 ，服务器响应代码为：\"+responseCode");
            }
        } catch (Exception e) {
            System.out.println("找不到网页源码："+e);
        }
    }
}
