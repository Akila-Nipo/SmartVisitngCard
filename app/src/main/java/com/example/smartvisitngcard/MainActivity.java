package com.example.smartvisitngcard;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ImageView phoneIcon, emailIcon, linkedinIcon, whatsappIcon, githubIcon, facebookIcon;
    private TextView phoneNumber, email, linkedin, whatsapp, github, facebook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView profilePicture = findViewById(R.id.profile_picture);
        profilePicture.setClipToOutline(true);
        phoneIcon = findViewById(R.id.phone_icon);
        emailIcon = findViewById(R.id.email_icon);
        linkedinIcon = findViewById(R.id.linkedin_icon);
        whatsappIcon = findViewById(R.id.whatsapp_icon);
        githubIcon = findViewById(R.id.github_icon);
        facebookIcon = findViewById(R.id.facebook_icon);

        phoneNumber = findViewById(R.id.phone_number);
        email = findViewById(R.id.email);
        linkedin = findViewById(R.id.linkedin);
        whatsapp = findViewById(R.id.whatsapp);
        github = findViewById(R.id.github);
        facebook = findViewById(R.id.facebook);

        // Set up handlers for changing text color temporarily
        Handler handler = new Handler();

        // Click listener for phone (Dial the number)
        View.OnClickListener dialerListener = v -> {
            changeTextColorTemporarily(phoneNumber, handler);
            Intent dialIntent = new Intent(Intent.ACTION_DIAL);
            dialIntent.setData(Uri.parse("tel:+8801785482292"));
            startActivity(dialIntent);
        };
        phoneIcon.setOnClickListener(dialerListener);
        phoneNumber.setOnClickListener(dialerListener);

        // Click listener for email (Open Gmail compose)
        View.OnClickListener emailListener = v -> {
            changeTextColorTemporarily(email, handler);
            Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
            emailIntent.setData(Uri.parse("mailto:akila.stu2019@juniv.edu"));
            startActivity(Intent.createChooser(emailIntent, "Send email using"));
        };
        emailIcon.setOnClickListener(emailListener);
        email.setOnClickListener(emailListener);

        // Click listener for LinkedIn
        View.OnClickListener linkedinListener = v -> {
            changeTextColorTemporarily(linkedin, handler);
            Intent linkedinIntent = new Intent(Intent.ACTION_VIEW);
            linkedinIntent.setData(Uri.parse("https://www.linkedin.com/in/akila-nipo-076256311/"));
            startActivity(linkedinIntent);
        };
        linkedinIcon.setOnClickListener(linkedinListener);
        linkedin.setOnClickListener(linkedinListener);

        // Click listener for WhatsApp
        View.OnClickListener whatsappListener = v -> {
            changeTextColorTemporarily(whatsapp, handler);
            Intent whatsappIntent = new Intent(Intent.ACTION_VIEW);
            whatsappIntent.setData(Uri.parse("https://wa.me/8801785482292"));
            startActivity(whatsappIntent);
        };
        whatsappIcon.setOnClickListener(whatsappListener);
        whatsapp.setOnClickListener(whatsappListener);

        // Click listener for GitHub
        View.OnClickListener githubListener = v -> {
            changeTextColorTemporarily(github, handler);
            Intent githubIntent = new Intent(Intent.ACTION_VIEW);
            githubIntent.setData(Uri.parse("https://github.com/Akila-Nipo"));
            startActivity(githubIntent);
        };
        githubIcon.setOnClickListener(githubListener);
        github.setOnClickListener(githubListener);

        // Click listener for Facebook
        View.OnClickListener facebookListener = v -> {
            changeTextColorTemporarily(facebook, handler);
            Intent facebookIntent = new Intent(Intent.ACTION_VIEW);
            facebookIntent.setData(Uri.parse("https://www.facebook.com/akila.nipo"));
            startActivity(facebookIntent);
        };
        facebookIcon.setOnClickListener(facebookListener);
        facebook.setOnClickListener(facebookListener);
    }

    // Method to change text color temporarily
    private void changeTextColorTemporarily(TextView textView, Handler handler) {
        int originalColor = textView.getCurrentTextColor();
        textView.setTextColor(Color.parseColor("#FFCC00")); // Change to yellow color when clicked
        handler.postDelayed(() -> textView.setTextColor(originalColor), 500); // Revert to original color after 500ms
    }
}
