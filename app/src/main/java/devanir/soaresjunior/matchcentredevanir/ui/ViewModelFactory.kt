package devanir.soaresjunior.matchcentredevanir.ui

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import devanir.soaresjunior.matchcentredevanir.data.repository.Repository
import java.lang.IllegalArgumentException
import javax.inject.Inject

class ViewModelFactory @Inject constructor(private val repository: Repository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(MatchCentreViewModel::class.java))
            MatchCentreViewModel(repository) as T
        else throw IllegalArgumentException("ViewModel Not Found!")
    }
}