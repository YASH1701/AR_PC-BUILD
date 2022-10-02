package com.godkiller.reoract;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageButton;

public class links extends AppCompatActivity {

    ImageButton cpu,ssd,gpu,hdd,mother,ram,smps,casee,fan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_links);

        cpu = findViewById(R.id.a);
        ssd = findViewById(R.id.b);
        gpu = findViewById(R.id.c);
        hdd = findViewById(R.id.d);
        mother = findViewById(R.id.e);
        ram = findViewById(R.id.f);
        smps = findViewById(R.id.g);
        casee = findViewById(R.id.h);
        fan = findViewById(R.id.i);

        cpu.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.amazon.in/dp/B07HHN6KBZ/ref=cm_sw_em_r_mt_dp_U_AoSlEb7TTRQ3M"));
            startActivity(intent);
        });
        ssd.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.amazon.in/dp/B07CGGP7SV/ref=cm_sw_em_r_mt_dp_U_rlSlEb9SJGVZH"));
            startActivity(intent);
        });
        gpu.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.amazon.in/MSI-GTX-1050-Ti-OCV1/dp/B075PJVRDG/ref=sr_1_fkmr1_2?keywords=msi+mini+1050&qid=1580236923&sr=8-2-fkmr1"));
            startActivity(intent);
        });
        hdd.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.amazon.in/Seagate-Barracuda-256MB-Desktop-Internal/dp/B071WLPRHN/ref=sr_1_3?crid=2KAC7UJQBRJZD&keywords=seagate+4tb+hard+disk&qid=1580236006&sprefix=seagate+4tb+hard%2Caps%2C536&sr=8-3"));
            startActivity(intent);
        });
        mother.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.amazon.in/ASUS-Prime-B360-Plus-LGA1151-Motherboard/dp/B07BRKN7L6/ref=sr_1_18?crid=2BSNYKVY3HOZB&keywords=asus+prime+motherboard&qid=1580236390&sprefix=asus+prime+mother%2Caps%2C627&sr=8-18"));
            startActivity(intent);
        });
        ram.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.amazon.in/dp/B07DLF25JS/ref=cm_sw_em_r_mt_dp_U_nMQlEbC87P65R"));
            startActivity(intent);
        });
        smps.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.amazon.in/dp/B07WSHNG28/ref=cm_sw_em_r_mt_dp_U_MDSlEbE5WT6Z5"));
            startActivity(intent);
        });
        casee.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.amazon.in/Corsair-CC-9011023-WW-Carbide-200R-Black/dp/B009GXZ8MM/ref=sr_1_2?crid=ID5MKHT6MR1K&keywords=corsair+200r&qid=1580124182&sprefix=corsair+20%2Caps%2C253&sr=8-2"));
            startActivity(intent);
        });
        fan.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.amazon.in/Corsair-CO-9050059-WW-Performance-single-controller/dp/B01LHYI374/ref=sr_1_3?keywords=corsair+sp120&qid=1580117164&sr=8-3"));
            startActivity(intent);
        });
    }
}
