package com.example.wits_vuvuzela_app;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.provider.DocumentsContract;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.InputStream;
import java.net.URL;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;


public class HomePage extends AppCompatActivity {

    TextView FName;
    TextView LName;
    TextView UName;
    TextView Email;
    TextView Password;
    private DatabaseReference databaseReference;
    String email;
    ListView listView;
    TextView textView_heading;

    ArrayList<String> ArticlesHead;
    ArrayList<String> ArticlesAuth;

    String[] Articles = {"Jacob Zuma","Wits University","Elections","Load Shedding","Champions League","University Graduation"};
    String[] ArticlesAuthor = {"1 Jan 2018","2 Feb 2018","3 Mar 2018","4 Apr 2018","5 May 2018","6 Jun 2019"};
    String[] ArticleHeading = {"State Capture Report","Best Institution in Africa","Eskom Crisis"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        ArticlesHead = new ArrayList<>();
        ArticlesAuth = new ArrayList<>();

        new doit().execute();

       // if(!ArticlesAuth.isEmpty()){
         //   Toast.makeText(HomePage.this,ArticlesAuth.get(0) + "aaaaa" ,Toast.LENGTH_LONG).show();
        //}

        //ArticlesHead.add("saas");
        //textView_heading.setText(ArticlesHead.get(0));
    }

    class CustomAdapter extends BaseAdapter{

        @Override
        public int getCount() {
          return ArticlesHead.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View convertView1 = layoutInflater.inflate(R.layout.articlelayout,parent,false);

            //ImageView imageView = convertView1.findViewById(R.id.ArticleImage);
            TextView textView_heading = convertView1.findViewById(R.id.ArticleHeading);
            TextView textView_author = convertView1 .findViewById(R.id.ArticleAuthor);

            //imageView.setImageResource(IMAGES[position]);
            textView_heading.setText(ArticlesHead.get(position));
            textView_author.setText(ArticlesAuth.get(position));
            return convertView1;

        }
    }

    public class doit extends AsyncTask<Void,Void,Void> {

        ArrayList<String> Heading1;
        ArrayList<String> Author1;

        String words = "";

        @Override
        protected Void doInBackground(Void... voids) {

            try {

                Heading1 = new ArrayList<>();
                Author1 = new ArrayList<>();

               // String imgURL  = "https://www.google.com/images/srpr/logo11w.png";
               // new DownLoadImageTask(iv).execute(imgURL);
                Document mBlogDocument = Jsoup.connect("https://witsvuvuzela.com/category/news/").get();
                Elements mElementDataSize = mBlogDocument.select("div[class=el-dbe-blog-extra block_extended]");
                // Locate the content attribute
                int mElementSize = mElementDataSize.size();

                for (int i = 0; i < 6 ; i++) {

                    Elements mElementArticle = mBlogDocument.select("h2[class=entry-title]").select("a[href]").eq(i);
                    String mArticleHead = mElementArticle.text();

                    Heading1.add(mArticleHead);
                    words+=mArticleHead;

                    Elements mElementAuthorName = mBlogDocument.select("span[class=author vcard]").select("a").eq(i);
                    String mAuthorName = mElementAuthorName.text();

                    Author1.add(mAuthorName);
                    words+=mAuthorName;

                    //Elements mElementCategories = mBlogDocument.select("div[class=post-categories]").select("a").eq(i);
                    //String mCategories = mElementArticle.attr("href");

                    //words+= mCategories;

                  //  Elements mElementAuthorName1 = mBlogDocument.select("class=[entry-featured-image-url]").select("img").eq(i);
                  //  String mAuthorName1 = mElementAuthorName1.attr("src");

                  //  words+= mAuthorName1;

                  //  words+="\n";

                    //Elements mElementArticle1 = mBlogDocument.select("h2[class=entry-title]").select("a[href]").eq(i);
                    //String mArticle1 = mElementArticle.attr("href");

                    //words += mArticle1.

                    //  Elements links = doc.select("a[href]");
                    //word = "\n" + "Link : " + link.attr("href") + "\n" + "Text : " + link.text();
/*
                    Elements mElementAuthorName = mBlogDocument.select("span[class=author vcard]").select("a").eq(i);
                    String mAuthorName = mElementAuthorName.text();

                    words+= mAuthorName;

                    Elements mElementBlogUploadDate = mBlogDocument.select("span[class=published]").eq(i);
                    String mBlogUploadDate = mElementBlogUploadDate.text();

                    words+=mBlogUploadDate;


                    words+="\n";
*/
                    // Elements mElementBlogUploadDate1 = mBlogDocument.select("rel=category tag").eq(i);
                    // String mBlogUploadDate1 = mElementBlogUploadDate1.text();

                    // words+=mBlogUploadDate1;
                    // words+="\n";

                    //  Elements mElementBlogUploadDate2 = mBlogDocument.select("span[class=published]").eq(i);
                    //  String mBlogUploadDate2 = mElementBlogUploadDate2.text();

                    //  words+=mBlogUploadDate2;
                    //  words+="\n";

                    //Elements mElementAuthorName = mBlogDocument.select("span[class=vcard author post-author test]").select("a").eq(i);
                    //String mAuthorName = mElementAuthorName.text();

                    // Elements mElementBlogUploadDate = mBlogDocument.select("span[class=post-date updated]").eq(i);
                    // String mBlogUploadDate = mElementBlogUploadDate.text();

                }
            }catch (Exception e){
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            ArticlesAuth = Author1;
            ArticlesHead = Heading1;
            Toast.makeText(HomePage.this,ArticlesAuth.get(0) ,Toast.LENGTH_LONG).show();

            listView =(ListView)findViewById(R.id.listview);

            CustomAdapter customAdapter = new CustomAdapter();

            listView.setAdapter(customAdapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(HomePage.this,ReadArticleActivity.class);
                    intent.putExtra("Author",ArticlesHead.get(position));
                    startActivity(intent);
                    Toast.makeText(HomePage.this,"Hello World",Toast.LENGTH_LONG).show();
                }
            });
            Toast.makeText(HomePage.this,"Entered" ,Toast.LENGTH_LONG).show();


        }
    }
/*
    private class DownLoadImageTask extends AsyncTask<String,Void, Bitmap>{
        ImageView imageView;

        public DownLoadImageTask(ImageView imageView){
            this.imageView = imageView;
        }

        protected Bitmap doInBackground(String...urls){
            String urlOfImage = urls[0];
            Bitmap logo = null;
            try{
                InputStream is = new URL(urlOfImage).openStream();

                logo = BitmapFactory.decodeStream(is);
            }catch(Exception e){
                e.printStackTrace();
            }
            return logo;
        }

        protected void onPostExecute(Bitmap result){
            imageView.setImageBitmap(result);
        }
    }*/

}


/*
    Intent intent = getIntent();
        email = intent.getStringExtra("Email");

                databaseReference = FirebaseDatabase.getInstance().getReference("UserProfile");

                FName = (TextView) findViewById(R.id.tvFirstName);
                LName = (TextView) findViewById(R.id.tvLastName);
                UName = (TextView) findViewById(R.id.tvUserName);
                Email = (TextView) findViewById(R.id.tvEmail);
//FName = (TextView)findViewById(R.id.tvP);
*/

    /*
    @Override
    protected void onStart() {
        super.onStart();

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot artistSnapshot : dataSnapshot.getChildren()) {

                    UserProfile userProfile = artistSnapshot.getValue(UserProfile.class);

                    if (userProfile.getUser_email().equals(email)) {

                        FName.setText(userProfile.getUser_fName());
                        LName.setText(userProfile.getUser_lName());
                        UName.setText(userProfile.getUser_username());
                        Email.setText(userProfile.getUser_email());

                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
*/
