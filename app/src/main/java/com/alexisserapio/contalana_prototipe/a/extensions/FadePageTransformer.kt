import android.view.View
import androidx.viewpager2.widget.ViewPager2
import kotlin.math.abs

class FadePageTransformer : ViewPager2.PageTransformer {
    override fun transformPage(page: View, position: Float) {
        page.apply {
            when {
                position <= -1f || position >= 1f -> alpha = 0f
                position == 0f -> alpha = 1f
                else -> alpha = 1f - abs(position)
            }
        }
    }
}