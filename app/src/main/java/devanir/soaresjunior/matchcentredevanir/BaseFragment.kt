package devanir.soaresjunior.matchcentredevanir

import android.os.Bundle
import android.support.v4.app.Fragment

abstract class BaseFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inject()
        createViewModel()
    }

    open fun inject() {}

    open fun createViewModel() {}
}