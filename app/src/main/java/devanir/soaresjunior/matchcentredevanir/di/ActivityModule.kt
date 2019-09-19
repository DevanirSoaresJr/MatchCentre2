package devanir.soaresjunior.matchcentredevanir.di

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import dagger.Module
import dagger.Provides
import devanir.soaresjunior.matchcentredevanir.data.repository.Repository
import devanir.soaresjunior.matchcentredevanir.data.repository.RepositoryImpl
import devanir.soaresjunior.matchcentredevanir.net.MatchService
import devanir.soaresjunior.matchcentredevanir.ui.MatchCentreViewModel
import devanir.soaresjunior.matchcentredevanir.ui.ViewModelFactory
import javax.inject.Singleton

@Module(includes = [NetworkModule::class])
class ActivityModule(private val appCompatActivity: AppCompatActivity) {
    @Provides
    @Singleton
    fun provideMatchCentreViewModel(factory: ViewModelFactory) = ViewModelProviders.of(appCompatActivity, factory)
        .get(MatchCentreViewModel::class.java)

    @Provides
    @Singleton
    fun provideRepository(matchService: MatchService): Repository = RepositoryImpl(matchService)
}