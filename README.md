This repository shows how to set up an Android project using [Dagger](https://google.github.io/dagger/).

# Features
- Default dependency injection (DI) setup 
> checkout [master](https://github.com/thuongleit/dagger-sample/tree/master)

- DI setup with [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) 
> checkout branch [dagger-view-model](https://github.com/thuongleit/dagger-sample/tree/dagger-view-model)

- DI setup with networking and [Retrofit](https://github.com/square/retrofit)
> checkout branch [dagger-retrofit](https://github.com/thuongleit/dagger-sample/tree/dagger-retrofit)
 
- DI setup with [WorkManager](https://developer.android.com/topic/libraries/architecture/workmanager/) 
> checkout branch [dagger-work-manager](https://github.com/thuongleit/dagger-sample/tree/dagger-work-manager)

# How to add new activity/fragment to DI

## Activity:

-  Add an activity, implements `HasSupportFragmentInjector`

```kotlin
class MainActivity : AppCompatActivity(), HasSupportFragmentInjector {

    @Inject
    lateinit var repository: SampleRepository

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    override fun supportFragmentInjector() = dispatchingAndroidInjector
}
```
- Register the activity to AndroidInjector in `ActivityModule`

```kotlin
@ContributesAndroidInjector(modules = [FragmentBuildersModule::class])
abstract fun contributeMainActivity(): MainActivity
```

## Fragment

- Add a fragment, implements `Injectable`

```kotlin
class MainFragment : Fragment(), Injectable {
}
```

- Register the fragment in `FragmentBuildersModule`

```kotlin
@ContributesAndroidInjector
abstract fun contributeMainFragment(): MainFragment
```

# How to add a new worker

- Add a new worker,e.g

- Add a Subcomponent for the worker

```kotlin
@Subcomponent
interface SampleWorkerComponent: AndroidInjector<SampleWorker> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<SampleWorker>()
}
```

- Register the worker and subcomponent to `WorkerModule`
 
```kotlin
@Module(subcomponents = [SampleWorkerComponent::class])
abstract class WorkerModule {

    @Binds
    @IntoMap
    @WorkerKey(SampleWorker::class)
    abstract fun bindWorkerFactory(profileWorker: SampleWorkerComponent.Builder): AndroidInjector.Factory<out Worker>
}
```

- Call inject in the worker class

```kotlin
override fun doWork(): Result {
    AndroidWorkerInjection.inject(this)
...
}
```

# Credit
This project is extracted and modified from [GithubBrowserSample](https://github.com/googlesamples/android-architecture-components/tree/master/GithubBrowserSample).