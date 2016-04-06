import Pojo.YurtFoto;
import Pojo.YurtPojo;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


public class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());


    public static void main(String[] args){
        List<String> URLUni = linkParse();
        List<String> headerList = parseHeader(URLUni);
        if (headerList != null && headerList.size() != 0) {
            //dataGet(liste);
            photoGet(headerList);
        }
    }


    private static List<String> parseHeader(List<String> URLUni) {
        Document doc2 = null;

        List<String> headerList = new ArrayList<String>();
        for (int b = 0; b < URLUni.size(); b++) {
            try {
                doc2 = Jsoup.connect(URLUni.get(b)).get();
            } catch (Exception e) {

            }
            if (doc2 != null) {

                try {
                    for (int c = 0; c < 100; c++) {
                        if (doc2.select("a.siyah_baslik").get(c) != null) {
                            Element link = doc2.select("a.siyah_baslik").get(c);
                            headerList.add("http://www.yurtarama.com/" + link.attr("href"));
                        } else
                            break;
                    }
                } catch (Exception e) {
                    System.out.printf("Ana başlık araması tamamlandı.\t" + URLUni.get(b) + "\n");
                }

                try {

                    for (int d = 0; d < 100; d++) {
                        if (doc2.select(".index_icerik_yazilar_kucuk .index_icerik_yazilar_1").get(d) != null) {
                            Element link = doc2.select(".index_icerik_yazilar_kucuk .index_icerik_yazilar_1").get(d);
                            headerList.add("http://www.yurtarama.com/" + link.attr("href"));
                        } else
                            break;
                    }

                } catch (Exception e) {
                    System.out.printf("Başlık araması tamamlandı.\t" + URLUni.get(b) + "\n");
                }
            }
        }
        return headerList;
    }

    public static List<String> linkParse() {
        List<String> ciktiUrller = new ArrayList<String>();
//        ciktiUrller.add("http://www.yurtarama.com/k-adana-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-15.html");
//        ciktiUrller.add("http://www.yurtarama.com/k-adiyaman-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-16.html");
//        ciktiUrller.add("http://www.yurtarama.com/k-afyonkarahisar-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-17.html");
//        ciktiUrller.add("http://www.yurtarama.com/k-agri-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-18.html");
//        ciktiUrller.add("http://www.yurtarama.com/k-aksaray-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-70.html");
//        ciktiUrller.add("http://www.yurtarama.com/k-amasya-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-19.html");
//        ciktiUrller.add("http://www.yurtarama.com/k-ankara-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-13.html");
//        ciktiUrller.add("http://www.yurtarama.com/k-antalya-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-20.html");
//        ciktiUrller.add("http://www.yurtarama.com/k-ardahan-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-77.html");
//        ciktiUrller.add("http://www.yurtarama.com/k-artvin-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-21.html");
//        ciktiUrller.add("http://www.yurtarama.com/k-aydin-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-22.html");
//        ciktiUrller.add("http://www.yurtarama.com/k-balikesir-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-23.html");
//        ciktiUrller.add("http://www.yurtarama.com/k-bartin-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-76.html");
//        ciktiUrller.add("http://www.yurtarama.com/k-batman-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-74.html");
//        ciktiUrller.add("http://www.yurtarama.com/k-bayburt-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-71.html");
//        ciktiUrller.add("http://www.yurtarama.com/k-bilecik-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-5.html");
//        ciktiUrller.add("http://www.yurtarama.com/k-bingol-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-24.html");
//        ciktiUrller.add("http://www.yurtarama.com/k-bitlis-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-25.html");
//        ciktiUrller.add("http://www.yurtarama.com/k-bolu-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-4.html");
//        ciktiUrller.add("http://www.yurtarama.com/k-burdur-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-26.html");
//        ciktiUrller.add("http://www.yurtarama.com/k-bursa-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-8.html");
//        ciktiUrller.add("http://www.yurtarama.com/k-canakkale-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-27.html");
//        ciktiUrller.add("http://www.yurtarama.com/k-cankiri-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-28.html");
//        ciktiUrller.add("http://www.yurtarama.com/k-corum-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-29.html");
//        ciktiUrller.add("http://www.yurtarama.com/k-denizli-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-30.html");
//        ciktiUrller.add("http://www.yurtarama.com/k-diyarbakir-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-31.html");
//        ciktiUrller.add("http://www.yurtarama.com/k-duzce-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-3.html");
//        ciktiUrller.add("http://www.yurtarama.com/k-edirne-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-32.html");
//        ciktiUrller.add("http://www.yurtarama.com/k-elazig-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-33.html");
//        ciktiUrller.add("http://www.yurtarama.com/k-erzincan-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-34.html");
//        ciktiUrller.add("http://www.yurtarama.com/k-erzurum-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-35.html");
//        ciktiUrller.add("http://www.yurtarama.com/k-eskisehir-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-12.html");
//        ciktiUrller.add("http://www.yurtarama.com/k-gaziantep-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-36.html");
//        ciktiUrller.add("http://www.yurtarama.com/k-giresun-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-37.html");
//        ciktiUrller.add("http://www.yurtarama.com/k-gumushane-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-38.html");
//        ciktiUrller.add("http://www.yurtarama.com/k-hakkari-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-39.html");
//        ciktiUrller.add("http://www.yurtarama.com/k-hatay-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-40.html");
//        ciktiUrller.add("http://www.yurtarama.com/k-igdir-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-78.html");
//        ciktiUrller.add("http://www.yurtarama.com/k-isparta-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-41.html");
        ciktiUrller.add("http://www.yurtarama.com/k-istanbul-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-9.html");
        ciktiUrller.add("http://www.yurtarama.com/k-izmir-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-10.html");
        ciktiUrller.add("http://www.yurtarama.com/k-kahramanmaras-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-49.html");
        ciktiUrller.add("http://www.yurtarama.com/k-karabuk-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-80.html");
        ciktiUrller.add("http://www.yurtarama.com/k-karaman-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-72.html");
        ciktiUrller.add("http://www.yurtarama.com/k-kars-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-2.html");
        ciktiUrller.add("http://www.yurtarama.com/k-kastamonu-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-43.html");
        ciktiUrller.add("http://www.yurtarama.com/k-kayseri-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-44.html");
        ciktiUrller.add("http://www.yurtarama.com/k-kibris-kktc-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-84.html");
        ciktiUrller.add("http://www.yurtarama.com/k-kirikkale-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-73.html");
        ciktiUrller.add("http://www.yurtarama.com/k-kirklareli-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-11.html");
        ciktiUrller.add("http://www.yurtarama.com/k-kirsehir-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-14.html");
        ciktiUrller.add("http://www.yurtarama.com/k-kilis-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-81.html");
        ciktiUrller.add("http://www.yurtarama.com/k-kocaeli-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-6.html");
        ciktiUrller.add("http://www.yurtarama.com/k-konya-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-45.html");
        ciktiUrller.add("http://www.yurtarama.com/k-kutahya-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-46.html");
        ciktiUrller.add("http://www.yurtarama.com/k-malatya-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-47.html");
        ciktiUrller.add("http://www.yurtarama.com/k-manisa-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-48.html");
        ciktiUrller.add("http://www.yurtarama.com/k-mardin-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-50.html");
        ciktiUrller.add("http://www.yurtarama.com/k-mersin-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-42.html");
        ciktiUrller.add("http://www.yurtarama.com/k-mugla-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-51.html");
        ciktiUrller.add("http://www.yurtarama.com/k-mus-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-52.html");
        ciktiUrller.add("http://www.yurtarama.com/k-nevsehir-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-53.html");
        ciktiUrller.add("http://www.yurtarama.com/k-nigde-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-54.html");
        ciktiUrller.add("http://www.yurtarama.com/k-ordu-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-55.html");
        ciktiUrller.add("http://www.yurtarama.com/k-osmaniye-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-82.html");
        ciktiUrller.add("http://www.yurtarama.com/k-rize-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-56.html");
        ciktiUrller.add("http://www.yurtarama.com/k-sakarya-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-1.html");
        ciktiUrller.add("http://www.yurtarama.com/k-samsun-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-57.html");
        ciktiUrller.add("http://www.yurtarama.com/k-siirt-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-58.html");
        ciktiUrller.add("http://www.yurtarama.com/k-sinop-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-59.html");
        ciktiUrller.add("http://www.yurtarama.com/k-sivas-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-60.html");
        ciktiUrller.add("http://www.yurtarama.com/k-sanliurfa-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-65.html");
        ciktiUrller.add("http://www.yurtarama.com/k-sirnak-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-75.html");
        ciktiUrller.add("http://www.yurtarama.com/k-tekirdag-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-61.html");
        ciktiUrller.add("http://www.yurtarama.com/k-tokat-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-62.html");
        ciktiUrller.add("http://www.yurtarama.com/k-trabzon-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-63.html");
        ciktiUrller.add("http://www.yurtarama.com/k-tunceli-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-64.html");
        ciktiUrller.add("http://www.yurtarama.com/k-usak-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-66.html");
        ciktiUrller.add("http://www.yurtarama.com/k-van-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-67.html");
        ciktiUrller.add("http://www.yurtarama.com/k-yalova-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-79.html");
        ciktiUrller.add("http://www.yurtarama.com/k-yozgat-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-68.html");
        ciktiUrller.add("http://www.yurtarama.com/k-zonguldak-ogrenci-yurtlari-yurdu-evleri-pansiyonlar-69.html");

        return ciktiUrller;

    }

    public static void photoGet(List<String> URLInformation) {
        List<YurtFoto> liste = new ArrayList<YurtFoto>();
        Document doc = null;

        for (int i = 0; i < URLInformation.size(); i++) {

            try {
                doc = Jsoup.connect(URLInformation.get(i)).get();
                LOGGER.info("Şuanki URL = " + URLInformation.get(i));
            } catch (Exception e) {

            }
            if (doc != null) {
                for (int j = 0; j < 8; j++) {
                    YurtFoto fotograf = new YurtFoto();
                    try {
                        fotograf.setYurtAdi(doc.select(".firma_baslik").first().text());
                    } catch (Exception e) {
                        fotograf.setYurtAdi("");
                        System.out.printf("yurt adında hata bulundu " + URLInformation.get(i) + "\n");
                    }
                    try {
                        if (doc.select(".yatay_manset").get(j) != null) {
                            Element turu = doc.select(".yatay_manset img").get(j);
                            URL url = new URL("http://www.yurtarama.com/" + turu.attr("src"));
                            InputStream in = new BufferedInputStream(url.openStream());
                            ByteArrayOutputStream out = new ByteArrayOutputStream();
                            byte[] buf = new byte[4096];
                            int n = 0;
                            while (-1!=(n=in.read(buf)))
                            {
                                out.write(buf, 0, n);
                            }
                            out.close();
                            in.close();
                            byte[] response = out.toByteArray();
                            String urlPrefix = "/Users/korhanozbek/Desktop/" + "yurt/";
                            String photoUrl = URLInformation.get(i).substring(25, URLInformation.get(i).length() - 10) + "_" + j + ".jpg";
                            FileOutputStream fos = new FileOutputStream(urlPrefix + photoUrl);
                            fos.write(response);
                            fos.close();

                            fotograf.setFotoAdi(photoUrl);
                        }


                    } catch (Exception e) {
                        try {
                            if (doc.select(".image" + j).first() !=null) {
                                Element aaa = doc.select(".image" + j).first();
                                String stringURL = "http://www.yurtarama.com/" + aaa.attr("src");
                                stringURL = stringURL.replace("fturunler", "furunler");
                                URL url = new URL(stringURL);
                                InputStream in = new BufferedInputStream(url.openStream());
                                ByteArrayOutputStream out = new ByteArrayOutputStream();
                                byte[] buf = new byte[4096];
                                int n = 0;
                                while (-1!=(n=in.read(buf)))
                                {
                                    out.write(buf, 0, n);
                                }
                                out.close();
                                in.close();
                                byte[] response = out.toByteArray();
                                String urlPrefix = "/Users/korhanozbek/Desktop/" + "yurt/";
                                String photoUrl = URLInformation.get(i).substring(25, URLInformation.get(i).length() - 10) + "_" + j + ".jpg";
                                FileOutputStream fos = new FileOutputStream(urlPrefix + photoUrl);
                                fos.write(response);
                                fos.close();

                                fotograf.setFotoAdi(photoUrl);
                            }
                        } catch (Exception e1) {
                            fotograf.setFotoAdi("");
                            System.out.printf("yurt fotoğrafında hata bulundu " + URLInformation.get(i) + "\n");
                        }

                    }

                    try {
                        String il = doc.select(".yol").first().text();
                        il = il.substring(34, il.indexOf(" ›", 35));
                        fotograf.setYurtIli(il);
                    } catch (Exception e) {
                        fotograf.setYurtIli("");
                        System.out.printf("yurt ilinde hata bulundu " + URLInformation.get(i) + "\n");
                    }

                    if (liste.size() > 25) {
                        photoSave(liste);
                        liste.clear();
                        if(fotograf.getFotoAdi()!=null && !(fotograf.getFotoAdi().equals("")))
                            liste.add(fotograf);
                    } else {
                        if(fotograf.getFotoAdi()!=null && !(fotograf.getFotoAdi().equals("")))
                            liste.add(fotograf);
                    }

                }

            }
        }
        if(!(liste.isEmpty())) {
            photoSave(liste);
            liste.clear();
        }
    }

    public static void photoSave(List<YurtFoto> list) {

        SessionFactory factory;
        try{
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }

        Session session = null;
        Session session2 = null;
        Transaction tx = null;
        try {


            session2 = factory.openSession();
            tx = session2.beginTransaction();
            for (int a = 0; a < list.size(); a++) {

                session = factory.openSession();
                String sql = "SELECT * FROM yurt.yurt y WHERE (y.ili='"+list.get(a).getYurtIli()+"'"+ " AND y.adi='"+list.get(a).getYurtAdi()+"')";
                SQLQuery sqlQuery = session.createSQLQuery(sql);
                sqlQuery.addEntity(YurtPojo.class);
                List<YurtPojo> query = (List<YurtPojo>) sqlQuery.list();
                session.flush();
                session.close();

                YurtFoto obje = new YurtFoto();
                obje = list.get(a);
                if(query.size()!=0)
                    obje.setYurtId(query.get(0).getId());

                session2.saveOrUpdate(obje);
                session2.flush();
                session2.clear();

            }
            tx.commit();
        }
        catch (Exception e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            if(session.isOpen())
                session.close();

            if(session2.isOpen())
                session2.close();
        }
    }

    public static void dataGet(List<String> URLInformation) {
        List<YurtPojo> liste = new ArrayList<YurtPojo>();
        Document doc = null;

        for(int i=0;i<URLInformation.size();i++) {
            YurtPojo yurt = new YurtPojo();
            try {
                doc = Jsoup.connect(URLInformation.get(i)).get();
            } catch (Exception e) {

            }
            if(doc!=null) {

                try{
                    String turu = doc.select(".firma_iletisim_yazi_yeni").first().text();
                    if(turu.contains("Erkek"))
                        yurt.setTuru(1);

                    if(turu.contains("Kız"))
                        yurt.setTuru(2);
                }
                catch (Exception e) {
                    yurt.setTuru(0);
                    System.out.printf("yurt turunde hata bulundu " + URLInformation.get(i) + "\n");
                }

                try{
                    yurt.setAdi(doc.select(".firma_baslik").first().text());
                }
                catch (Exception e) {
                    yurt.setAdi("");
                    System.out.printf("yurt adında hata bulundu " + URLInformation.get(i) + "\n");
                }

                try{
                    String il = doc.select(".yol").first().text();
                    il = il.substring(34,il.indexOf(" ›",35));
                    yurt.setIli(il);
                }
                catch (Exception e) {
                    yurt.setIli("");
                    System.out.printf("yurt ilinde hata bulundu " + URLInformation.get(i) + "\n");
                }

                try{
                    int j = 0;
                    for(j = 0; j<7;j++) {
                        if(doc.select(".yazi5_bold").get(j).text().contains("Adres")) {
                            yurt.setAdres(doc.select(".yurt_yazi1").get(j).text());
                            break;
                        }
                        else
                            yurt.setAdres("");
                    }

                }
                catch (Exception e) {
                    yurt.setAdres("");
                    System.out.printf("yurt adresinde hata bulundu " + URLInformation.get(i) + "\n");
                }

                try{
                    int j = 0;
                    for(j = 0; j<7;j++) {
                        if(doc.select(".yazi5_bold").get(j).text().contains("Sabit")) {
                            yurt.setSabitTelefon(doc.select(".yurt_yazi1").get(j).text());
                            break;
                        }
                        else
                            yurt.setSabitTelefon("");
                    }
                }
                catch (Exception e) {
                    yurt.setSabitTelefon("");
                    System.out.printf("yurt sabit telefon hata bulundu " + URLInformation.get(i) + "\n");
                }

                try{
                    int j = 0;
                    for(j = 0; j<7;j++) {
                        if(doc.select(".yazi5_bold").get(j).text().contains("Cep")) {
                            yurt.setCepTelefonu(doc.select(".yurt_yazi1").get(j).text());
                            break;
                        }
                        else
                            yurt.setCepTelefonu("");
                    }

                } catch (Exception e) {
                    yurt.setCepTelefonu("");
                    System.out.printf("yurt setCep_telefonu hata bulundu " + URLInformation.get(i) + "\n");
                }

                try{
                    int j = 0;
                    for(j = 0; j<7;j++) {
                        if(doc.select(".yazi5_bold").get(j).text().contains("Web") &&
                                doc.select(".yurt_yazi1").get(j).text().startsWith("www")) {
                            yurt.setWebSitesi(doc.select(".yurt_yazi1").get(j).text());
                            break;
                        }
                        else
                            yurt.setWebSitesi("");
                    }

                } catch (Exception e) {
                    yurt.setWebSitesi("");
                    System.out.printf("yurt web adresi hata bulundu " + URLInformation.get(i) + "\n");
                }

                try{
                    int j = 0;
                    for(j = 0; j<7;j++) {
                        if(doc.select(".yazi5_bold").get(j).text().contains("Büyüklüğü")) {
                            String kapasite = doc.select(".yazi5_bold").get(j).text();
                            kapasite = kapasite.substring(kapasite.indexOf(":")+2,kapasite.length());
                            yurt.setKapasite(Integer.parseInt(kapasite));
                            break;
                        }
                        else
                            yurt.setKapasite(0);
                    }

                } catch (Exception e) {
                    yurt.setKapasite(0);
                    System.out.printf("yurt setKapasite hata bulundu " + URLInformation.get(i) + "\n");
                }

                try{
                    int j = 0;
                    for(j = 0; j<7;j++) {
                        if(doc.select(".yazi5_bold").get(j).text().contains("E-Posta")) {
                            yurt.setEmail(doc.select(".yurt_yazi1").get(j).text());
                            break;
                        }
                        else
                            yurt.setEmail("");
                    }

                } catch (Exception e) {
                    yurt.setEmail("");
                    System.out.printf("yurt Email hata bulundu " + URLInformation.get(i) + "\n");
                }


                try{
                    yurt.setAciklama(doc.select(".firma_onemli_bilgi").first().text());

                } catch (Exception e) {
                    yurt.setAciklama("");
                    System.out.printf("yurt setAciklama hata bulundu " + URLInformation.get(i) + "\n");
                }
                if(liste.size()>25) {
                    dataSave(liste);
                    liste.clear();
                    liste.add(yurt);
                }else
                    liste.add(yurt);
            }

        }
        if(liste.size()!=0)
            dataSave(liste);
    }

    public static void dataSave(List<YurtPojo> list) {

        SessionFactory factory;
        try{
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }

        Session session = null;
        Transaction tx = null;
        try {

                session = factory.openSession();

                tx = session.beginTransaction();
                for (int a = 0; a < list.size(); a++)
                    session.save(list.get(a));
                tx.commit();
        }
        catch (Exception e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            if(session.isOpen())
            session.close();
        }
    }

    }
