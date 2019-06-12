package io.github.ovso.glidepreloadtest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.btn_main_clear_cache
import kotlinx.android.synthetic.main.activity_main.btn_main_load_img
import kotlinx.android.synthetic.main.activity_main.btn_main_preload
import kotlinx.android.synthetic.main.activity_main.imageview_main_four
import kotlinx.android.synthetic.main.activity_main.imageview_main_one
import kotlinx.android.synthetic.main.activity_main.imageview_main_three
import kotlinx.android.synthetic.main.activity_main.imageview_main_two

class MainActivity : AppCompatActivity() {
  companion object {
    const val imageUrlOne =
      "https://i.pinimg.com/564x/30/0c/b4/300cb4192beec076dd28e65c45d22e76.jpg"
    const val imageUrlTwo =
      "https://png.pngtree.com/png_detail/20181016/floating-fog-png-clipart_368839.png"
    const val imageUrlThree =
      "https://t1.daumcdn.net/cfile/tistory/200EA1334E0814D01A?original"
    const val imageUrlFour =
      "https://t1.daumcdn.net/cfile/tistory/243198415957B71936"
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    btn_main_clear_cache.setOnClickListener {
      Glide.with(this).clear(imageview_main_one)
      Glide.with(this).clear(imageview_main_two)
      Glide.with(this).clear(imageview_main_three)
      Glide.with(this).clear(imageview_main_four)
      Glide.get(this).clearMemory()
      Thread(Runnable {
        Glide.get(this).clearDiskCache()
      }).start()
    }
    btn_main_load_img.setOnClickListener {
      Glide.with(this).load(imageUrlOne).into(imageview_main_one)
      Glide.with(this).load(imageUrlTwo).into(imageview_main_two)
      Glide.with(this).load(imageUrlThree).into(imageview_main_three)
      Glide.with(this).load(imageUrlFour).into(imageview_main_four)
    }
    btn_main_preload.setOnClickListener {
      Glide.with(this).load(imageUrlOne).preload()
      Glide.with(this).load(imageUrlTwo).preload()
      Glide.with(this).load(imageUrlThree).preload()
      Glide.with(this).load(imageUrlFour).preload()
    }
  }

}