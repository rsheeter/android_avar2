package com.example.avar2ftw

import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.core.graphics.TypefaceCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContentView(R.layout.activity_main)
    ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
      val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
      v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
      insets
    }

    var layout = findViewById<LinearLayout>(R.id.linear);

    createWeightRamp(layout, "roboto_avar1.ttf");
    createWeightRamp(layout, "roboto_avar2.ttf");
  }

  fun createWeightRamp(parent: ViewGroup, font_path: String) {
    for (i in 1..9) {
      val wght = i * 100;
      val tv = TextView(applicationContext);
      tv.text = "Hamburgevons ($wght, $font_path)";
      var type = Typeface.Builder(assets, font_path)
        .setFontVariationSettings("'wght' ${wght}")
        .build();
      tv.typeface = type;
      parent.addView(tv);
    }
  }
}