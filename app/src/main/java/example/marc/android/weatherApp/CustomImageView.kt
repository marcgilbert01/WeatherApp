package example.marc.android.weatherApp

import android.content.Context
import android.net.Uri
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView
import com.bumptech.glide.Glide

class CustomImageView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AppCompatImageView(context, attrs, defStyleAttr)  {

    fun setUrl(imageUrl: String?) {
        Glide
            .with(this)
            .load(imageUrl)
            .into(this)
    }

    override fun setImageURI(uri: Uri?) {
        setUrl(uri.toString())
    }
}
