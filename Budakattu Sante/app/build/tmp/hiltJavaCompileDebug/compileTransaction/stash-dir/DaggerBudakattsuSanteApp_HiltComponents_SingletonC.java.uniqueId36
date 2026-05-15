package com.budakattusante;

import android.app.Activity;
import android.app.Service;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import com.budakattusante.data.db.AppDatabase;
import com.budakattusante.data.db.dao.OrderDao;
import com.budakattusante.data.db.dao.ProductDao;
import com.budakattusante.data.db.dao.TribalFamilyDao;
import com.budakattusante.data.db.dao.UserDao;
import com.budakattusante.data.preferences.SessionManager;
import com.budakattusante.data.repository.OrderRepository;
import com.budakattusante.data.repository.ProductRepository;
import com.budakattusante.data.repository.UserRepository;
import com.budakattusante.di.AppModule_ProvideDatabaseFactory;
import com.budakattusante.di.AppModule_ProvideOrderDaoFactory;
import com.budakattusante.di.AppModule_ProvideProductDaoFactory;
import com.budakattusante.di.AppModule_ProvideTribalFamilyDaoFactory;
import com.budakattusante.di.AppModule_ProvideUserDaoFactory;
import com.budakattusante.ui.LeaderActivity;
import com.budakattusante.ui.MainActivity;
import com.budakattusante.ui.auth.AuthViewModel;
import com.budakattusante.ui.auth.AuthViewModel_HiltModules_KeyModule_ProvideFactory;
import com.budakattusante.ui.auth.LoginActivity;
import com.budakattusante.ui.auth.RegisterActivity;
import com.budakattusante.ui.buyer.BuyerHomeFragment;
import com.budakattusante.ui.buyer.BuyerHomeFragment_MembersInjector;
import com.budakattusante.ui.buyer.OrderHistoryFragment;
import com.budakattusante.ui.buyer.OrderHistoryFragment_MembersInjector;
import com.budakattusante.ui.buyer.PreorderFragment;
import com.budakattusante.ui.buyer.PreorderFragment_MembersInjector;
import com.budakattusante.ui.buyer.ProductDetailFragment;
import com.budakattusante.ui.buyer.ProductListFragment;
import com.budakattusante.ui.buyer.ProfileFragment;
import com.budakattusante.ui.buyer.ProfileFragment_MembersInjector;
import com.budakattusante.ui.leader.AddProductFragment;
import com.budakattusante.ui.leader.AnalyticsFragment;
import com.budakattusante.ui.leader.LeaderDashboardFragment;
import com.budakattusante.ui.leader.LeaderDashboardFragment_MembersInjector;
import com.budakattusante.ui.leader.LeaderProfileFragment;
import com.budakattusante.ui.leader.LeaderProfileFragment_MembersInjector;
import com.budakattusante.ui.leader.ManageProductsFragment;
import com.budakattusante.ui.splash.SplashActivity;
import com.budakattusante.ui.splash.SplashActivity_MembersInjector;
import com.budakattusante.ui.viewmodel.OrderViewModel;
import com.budakattusante.ui.viewmodel.OrderViewModel_HiltModules_KeyModule_ProvideFactory;
import com.budakattusante.ui.viewmodel.ProductViewModel;
import com.budakattusante.ui.viewmodel.ProductViewModel_HiltModules_KeyModule_ProvideFactory;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import dagger.hilt.android.ActivityRetainedLifecycle;
import dagger.hilt.android.ViewModelLifecycle;
import dagger.hilt.android.internal.builders.ActivityComponentBuilder;
import dagger.hilt.android.internal.builders.ActivityRetainedComponentBuilder;
import dagger.hilt.android.internal.builders.FragmentComponentBuilder;
import dagger.hilt.android.internal.builders.ServiceComponentBuilder;
import dagger.hilt.android.internal.builders.ViewComponentBuilder;
import dagger.hilt.android.internal.builders.ViewModelComponentBuilder;
import dagger.hilt.android.internal.builders.ViewWithFragmentComponentBuilder;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories_InternalFactoryFactory_Factory;
import dagger.hilt.android.internal.managers.ActivityRetainedComponentManager_LifecycleModule_ProvideActivityRetainedLifecycleFactory;
import dagger.hilt.android.internal.managers.SavedStateHandleHolder;
import dagger.hilt.android.internal.modules.ApplicationContextModule;
import dagger.hilt.android.internal.modules.ApplicationContextModule_ProvideContextFactory;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.MapBuilder;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import dagger.internal.SetBuilder;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;

@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class DaggerBudakattsuSanteApp_HiltComponents_SingletonC {
  private DaggerBudakattsuSanteApp_HiltComponents_SingletonC() {
  }

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private ApplicationContextModule applicationContextModule;

    private Builder() {
    }

    public Builder applicationContextModule(ApplicationContextModule applicationContextModule) {
      this.applicationContextModule = Preconditions.checkNotNull(applicationContextModule);
      return this;
    }

    public BudakattsuSanteApp_HiltComponents.SingletonC build() {
      Preconditions.checkBuilderRequirement(applicationContextModule, ApplicationContextModule.class);
      return new SingletonCImpl(applicationContextModule);
    }
  }

  private static final class ActivityRetainedCBuilder implements BudakattsuSanteApp_HiltComponents.ActivityRetainedC.Builder {
    private final SingletonCImpl singletonCImpl;

    private SavedStateHandleHolder savedStateHandleHolder;

    private ActivityRetainedCBuilder(SingletonCImpl singletonCImpl) {
      this.singletonCImpl = singletonCImpl;
    }

    @Override
    public ActivityRetainedCBuilder savedStateHandleHolder(
        SavedStateHandleHolder savedStateHandleHolder) {
      this.savedStateHandleHolder = Preconditions.checkNotNull(savedStateHandleHolder);
      return this;
    }

    @Override
    public BudakattsuSanteApp_HiltComponents.ActivityRetainedC build() {
      Preconditions.checkBuilderRequirement(savedStateHandleHolder, SavedStateHandleHolder.class);
      return new ActivityRetainedCImpl(singletonCImpl, savedStateHandleHolder);
    }
  }

  private static final class ActivityCBuilder implements BudakattsuSanteApp_HiltComponents.ActivityC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private Activity activity;

    private ActivityCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
    }

    @Override
    public ActivityCBuilder activity(Activity activity) {
      this.activity = Preconditions.checkNotNull(activity);
      return this;
    }

    @Override
    public BudakattsuSanteApp_HiltComponents.ActivityC build() {
      Preconditions.checkBuilderRequirement(activity, Activity.class);
      return new ActivityCImpl(singletonCImpl, activityRetainedCImpl, activity);
    }
  }

  private static final class FragmentCBuilder implements BudakattsuSanteApp_HiltComponents.FragmentC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private Fragment fragment;

    private FragmentCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
    }

    @Override
    public FragmentCBuilder fragment(Fragment fragment) {
      this.fragment = Preconditions.checkNotNull(fragment);
      return this;
    }

    @Override
    public BudakattsuSanteApp_HiltComponents.FragmentC build() {
      Preconditions.checkBuilderRequirement(fragment, Fragment.class);
      return new FragmentCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, fragment);
    }
  }

  private static final class ViewWithFragmentCBuilder implements BudakattsuSanteApp_HiltComponents.ViewWithFragmentC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl;

    private View view;

    private ViewWithFragmentCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl,
        FragmentCImpl fragmentCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
      this.fragmentCImpl = fragmentCImpl;
    }

    @Override
    public ViewWithFragmentCBuilder view(View view) {
      this.view = Preconditions.checkNotNull(view);
      return this;
    }

    @Override
    public BudakattsuSanteApp_HiltComponents.ViewWithFragmentC build() {
      Preconditions.checkBuilderRequirement(view, View.class);
      return new ViewWithFragmentCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, fragmentCImpl, view);
    }
  }

  private static final class ViewCBuilder implements BudakattsuSanteApp_HiltComponents.ViewC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private View view;

    private ViewCBuilder(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
        ActivityCImpl activityCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
    }

    @Override
    public ViewCBuilder view(View view) {
      this.view = Preconditions.checkNotNull(view);
      return this;
    }

    @Override
    public BudakattsuSanteApp_HiltComponents.ViewC build() {
      Preconditions.checkBuilderRequirement(view, View.class);
      return new ViewCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, view);
    }
  }

  private static final class ViewModelCBuilder implements BudakattsuSanteApp_HiltComponents.ViewModelC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private SavedStateHandle savedStateHandle;

    private ViewModelLifecycle viewModelLifecycle;

    private ViewModelCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
    }

    @Override
    public ViewModelCBuilder savedStateHandle(SavedStateHandle handle) {
      this.savedStateHandle = Preconditions.checkNotNull(handle);
      return this;
    }

    @Override
    public ViewModelCBuilder viewModelLifecycle(ViewModelLifecycle viewModelLifecycle) {
      this.viewModelLifecycle = Preconditions.checkNotNull(viewModelLifecycle);
      return this;
    }

    @Override
    public BudakattsuSanteApp_HiltComponents.ViewModelC build() {
      Preconditions.checkBuilderRequirement(savedStateHandle, SavedStateHandle.class);
      Preconditions.checkBuilderRequirement(viewModelLifecycle, ViewModelLifecycle.class);
      return new ViewModelCImpl(singletonCImpl, activityRetainedCImpl, savedStateHandle, viewModelLifecycle);
    }
  }

  private static final class ServiceCBuilder implements BudakattsuSanteApp_HiltComponents.ServiceC.Builder {
    private final SingletonCImpl singletonCImpl;

    private Service service;

    private ServiceCBuilder(SingletonCImpl singletonCImpl) {
      this.singletonCImpl = singletonCImpl;
    }

    @Override
    public ServiceCBuilder service(Service service) {
      this.service = Preconditions.checkNotNull(service);
      return this;
    }

    @Override
    public BudakattsuSanteApp_HiltComponents.ServiceC build() {
      Preconditions.checkBuilderRequirement(service, Service.class);
      return new ServiceCImpl(singletonCImpl, service);
    }
  }

  private static final class ViewWithFragmentCImpl extends BudakattsuSanteApp_HiltComponents.ViewWithFragmentC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl;

    private final ViewWithFragmentCImpl viewWithFragmentCImpl = this;

    private ViewWithFragmentCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl,
        FragmentCImpl fragmentCImpl, View viewParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
      this.fragmentCImpl = fragmentCImpl;


    }
  }

  private static final class FragmentCImpl extends BudakattsuSanteApp_HiltComponents.FragmentC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl = this;

    private FragmentCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl,
        Fragment fragmentParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;


    }

    @Override
    public void injectBuyerHomeFragment(BuyerHomeFragment buyerHomeFragment) {
      injectBuyerHomeFragment2(buyerHomeFragment);
    }

    @Override
    public void injectOrderHistoryFragment(OrderHistoryFragment orderHistoryFragment) {
      injectOrderHistoryFragment2(orderHistoryFragment);
    }

    @Override
    public void injectPreorderFragment(PreorderFragment preorderFragment) {
      injectPreorderFragment2(preorderFragment);
    }

    @Override
    public void injectProductDetailFragment(ProductDetailFragment productDetailFragment) {
    }

    @Override
    public void injectProductListFragment(ProductListFragment productListFragment) {
    }

    @Override
    public void injectProfileFragment(ProfileFragment profileFragment) {
      injectProfileFragment2(profileFragment);
    }

    @Override
    public void injectAddProductFragment(AddProductFragment addProductFragment) {
    }

    @Override
    public void injectAnalyticsFragment(AnalyticsFragment analyticsFragment) {
    }

    @Override
    public void injectLeaderDashboardFragment(LeaderDashboardFragment leaderDashboardFragment) {
      injectLeaderDashboardFragment2(leaderDashboardFragment);
    }

    @Override
    public void injectLeaderProfileFragment(LeaderProfileFragment leaderProfileFragment) {
      injectLeaderProfileFragment2(leaderProfileFragment);
    }

    @Override
    public void injectManageProductsFragment(ManageProductsFragment manageProductsFragment) {
    }

    @Override
    public DefaultViewModelFactories.InternalFactoryFactory getHiltInternalFactoryFactory() {
      return activityCImpl.getHiltInternalFactoryFactory();
    }

    @Override
    public ViewWithFragmentComponentBuilder viewWithFragmentComponentBuilder() {
      return new ViewWithFragmentCBuilder(singletonCImpl, activityRetainedCImpl, activityCImpl, fragmentCImpl);
    }

    @CanIgnoreReturnValue
    private BuyerHomeFragment injectBuyerHomeFragment2(BuyerHomeFragment instance) {
      BuyerHomeFragment_MembersInjector.injectSessionManager(instance, singletonCImpl.sessionManagerProvider.get());
      return instance;
    }

    @CanIgnoreReturnValue
    private OrderHistoryFragment injectOrderHistoryFragment2(OrderHistoryFragment instance) {
      OrderHistoryFragment_MembersInjector.injectSessionManager(instance, singletonCImpl.sessionManagerProvider.get());
      return instance;
    }

    @CanIgnoreReturnValue
    private PreorderFragment injectPreorderFragment2(PreorderFragment instance) {
      PreorderFragment_MembersInjector.injectSessionManager(instance, singletonCImpl.sessionManagerProvider.get());
      return instance;
    }

    @CanIgnoreReturnValue
    private ProfileFragment injectProfileFragment2(ProfileFragment instance) {
      ProfileFragment_MembersInjector.injectSessionManager(instance, singletonCImpl.sessionManagerProvider.get());
      return instance;
    }

    @CanIgnoreReturnValue
    private LeaderDashboardFragment injectLeaderDashboardFragment2(
        LeaderDashboardFragment instance) {
      LeaderDashboardFragment_MembersInjector.injectSessionManager(instance, singletonCImpl.sessionManagerProvider.get());
      return instance;
    }

    @CanIgnoreReturnValue
    private LeaderProfileFragment injectLeaderProfileFragment2(LeaderProfileFragment instance) {
      LeaderProfileFragment_MembersInjector.injectSessionManager(instance, singletonCImpl.sessionManagerProvider.get());
      return instance;
    }
  }

  private static final class ViewCImpl extends BudakattsuSanteApp_HiltComponents.ViewC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final ViewCImpl viewCImpl = this;

    private ViewCImpl(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
        ActivityCImpl activityCImpl, View viewParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;


    }
  }

  private static final class ActivityCImpl extends BudakattsuSanteApp_HiltComponents.ActivityC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl = this;

    private ActivityCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, Activity activityParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;


    }

    @Override
    public void injectLeaderActivity(LeaderActivity leaderActivity) {
    }

    @Override
    public void injectMainActivity(MainActivity mainActivity) {
    }

    @Override
    public void injectLoginActivity(LoginActivity loginActivity) {
    }

    @Override
    public void injectRegisterActivity(RegisterActivity registerActivity) {
    }

    @Override
    public void injectSplashActivity(SplashActivity splashActivity) {
      injectSplashActivity2(splashActivity);
    }

    @Override
    public DefaultViewModelFactories.InternalFactoryFactory getHiltInternalFactoryFactory() {
      return DefaultViewModelFactories_InternalFactoryFactory_Factory.newInstance(getViewModelKeys(), new ViewModelCBuilder(singletonCImpl, activityRetainedCImpl));
    }

    @Override
    public Set<String> getViewModelKeys() {
      return SetBuilder.<String>newSetBuilder(3).add(AuthViewModel_HiltModules_KeyModule_ProvideFactory.provide()).add(OrderViewModel_HiltModules_KeyModule_ProvideFactory.provide()).add(ProductViewModel_HiltModules_KeyModule_ProvideFactory.provide()).build();
    }

    @Override
    public ViewModelComponentBuilder getViewModelComponentBuilder() {
      return new ViewModelCBuilder(singletonCImpl, activityRetainedCImpl);
    }

    @Override
    public FragmentComponentBuilder fragmentComponentBuilder() {
      return new FragmentCBuilder(singletonCImpl, activityRetainedCImpl, activityCImpl);
    }

    @Override
    public ViewComponentBuilder viewComponentBuilder() {
      return new ViewCBuilder(singletonCImpl, activityRetainedCImpl, activityCImpl);
    }

    @CanIgnoreReturnValue
    private SplashActivity injectSplashActivity2(SplashActivity instance) {
      SplashActivity_MembersInjector.injectSessionManager(instance, singletonCImpl.sessionManagerProvider.get());
      return instance;
    }
  }

  private static final class ViewModelCImpl extends BudakattsuSanteApp_HiltComponents.ViewModelC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ViewModelCImpl viewModelCImpl = this;

    private Provider<AuthViewModel> authViewModelProvider;

    private Provider<OrderViewModel> orderViewModelProvider;

    private Provider<ProductViewModel> productViewModelProvider;

    private ViewModelCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, SavedStateHandle savedStateHandleParam,
        ViewModelLifecycle viewModelLifecycleParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;

      initialize(savedStateHandleParam, viewModelLifecycleParam);

    }

    @SuppressWarnings("unchecked")
    private void initialize(final SavedStateHandle savedStateHandleParam,
        final ViewModelLifecycle viewModelLifecycleParam) {
      this.authViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 0);
      this.orderViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 1);
      this.productViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 2);
    }

    @Override
    public Map<String, javax.inject.Provider<ViewModel>> getHiltViewModelMap() {
      return MapBuilder.<String, javax.inject.Provider<ViewModel>>newMapBuilder(3).put("com.budakattusante.ui.auth.AuthViewModel", ((Provider) authViewModelProvider)).put("com.budakattusante.ui.viewmodel.OrderViewModel", ((Provider) orderViewModelProvider)).put("com.budakattusante.ui.viewmodel.ProductViewModel", ((Provider) productViewModelProvider)).build();
    }

    @Override
    public Map<String, Object> getHiltViewModelAssistedMap() {
      return Collections.<String, Object>emptyMap();
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final SingletonCImpl singletonCImpl;

      private final ActivityRetainedCImpl activityRetainedCImpl;

      private final ViewModelCImpl viewModelCImpl;

      private final int id;

      SwitchingProvider(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
          ViewModelCImpl viewModelCImpl, int id) {
        this.singletonCImpl = singletonCImpl;
        this.activityRetainedCImpl = activityRetainedCImpl;
        this.viewModelCImpl = viewModelCImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // com.budakattusante.ui.auth.AuthViewModel 
          return (T) new AuthViewModel(singletonCImpl.userRepositoryProvider.get(), singletonCImpl.sessionManagerProvider.get());

          case 1: // com.budakattusante.ui.viewmodel.OrderViewModel 
          return (T) new OrderViewModel(singletonCImpl.orderRepositoryProvider.get(), singletonCImpl.productRepositoryProvider.get());

          case 2: // com.budakattusante.ui.viewmodel.ProductViewModel 
          return (T) new ProductViewModel(singletonCImpl.productRepositoryProvider.get());

          default: throw new AssertionError(id);
        }
      }
    }
  }

  private static final class ActivityRetainedCImpl extends BudakattsuSanteApp_HiltComponents.ActivityRetainedC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl = this;

    private Provider<ActivityRetainedLifecycle> provideActivityRetainedLifecycleProvider;

    private ActivityRetainedCImpl(SingletonCImpl singletonCImpl,
        SavedStateHandleHolder savedStateHandleHolderParam) {
      this.singletonCImpl = singletonCImpl;

      initialize(savedStateHandleHolderParam);

    }

    @SuppressWarnings("unchecked")
    private void initialize(final SavedStateHandleHolder savedStateHandleHolderParam) {
      this.provideActivityRetainedLifecycleProvider = DoubleCheck.provider(new SwitchingProvider<ActivityRetainedLifecycle>(singletonCImpl, activityRetainedCImpl, 0));
    }

    @Override
    public ActivityComponentBuilder activityComponentBuilder() {
      return new ActivityCBuilder(singletonCImpl, activityRetainedCImpl);
    }

    @Override
    public ActivityRetainedLifecycle getActivityRetainedLifecycle() {
      return provideActivityRetainedLifecycleProvider.get();
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final SingletonCImpl singletonCImpl;

      private final ActivityRetainedCImpl activityRetainedCImpl;

      private final int id;

      SwitchingProvider(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
          int id) {
        this.singletonCImpl = singletonCImpl;
        this.activityRetainedCImpl = activityRetainedCImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // dagger.hilt.android.ActivityRetainedLifecycle 
          return (T) ActivityRetainedComponentManager_LifecycleModule_ProvideActivityRetainedLifecycleFactory.provideActivityRetainedLifecycle();

          default: throw new AssertionError(id);
        }
      }
    }
  }

  private static final class ServiceCImpl extends BudakattsuSanteApp_HiltComponents.ServiceC {
    private final SingletonCImpl singletonCImpl;

    private final ServiceCImpl serviceCImpl = this;

    private ServiceCImpl(SingletonCImpl singletonCImpl, Service serviceParam) {
      this.singletonCImpl = singletonCImpl;


    }
  }

  private static final class SingletonCImpl extends BudakattsuSanteApp_HiltComponents.SingletonC {
    private final ApplicationContextModule applicationContextModule;

    private final SingletonCImpl singletonCImpl = this;

    private Provider<SessionManager> sessionManagerProvider;

    private Provider<AppDatabase> provideDatabaseProvider;

    private Provider<UserRepository> userRepositoryProvider;

    private Provider<OrderRepository> orderRepositoryProvider;

    private Provider<ProductRepository> productRepositoryProvider;

    private SingletonCImpl(ApplicationContextModule applicationContextModuleParam) {
      this.applicationContextModule = applicationContextModuleParam;
      initialize(applicationContextModuleParam);

    }

    private UserDao userDao() {
      return AppModule_ProvideUserDaoFactory.provideUserDao(provideDatabaseProvider.get());
    }

    private OrderDao orderDao() {
      return AppModule_ProvideOrderDaoFactory.provideOrderDao(provideDatabaseProvider.get());
    }

    private ProductDao productDao() {
      return AppModule_ProvideProductDaoFactory.provideProductDao(provideDatabaseProvider.get());
    }

    private TribalFamilyDao tribalFamilyDao() {
      return AppModule_ProvideTribalFamilyDaoFactory.provideTribalFamilyDao(provideDatabaseProvider.get());
    }

    @SuppressWarnings("unchecked")
    private void initialize(final ApplicationContextModule applicationContextModuleParam) {
      this.sessionManagerProvider = DoubleCheck.provider(new SwitchingProvider<SessionManager>(singletonCImpl, 0));
      this.provideDatabaseProvider = DoubleCheck.provider(new SwitchingProvider<AppDatabase>(singletonCImpl, 2));
      this.userRepositoryProvider = DoubleCheck.provider(new SwitchingProvider<UserRepository>(singletonCImpl, 1));
      this.orderRepositoryProvider = DoubleCheck.provider(new SwitchingProvider<OrderRepository>(singletonCImpl, 3));
      this.productRepositoryProvider = DoubleCheck.provider(new SwitchingProvider<ProductRepository>(singletonCImpl, 4));
    }

    @Override
    public void injectBudakattsuSanteApp(BudakattsuSanteApp budakattsuSanteApp) {
    }

    @Override
    public Set<Boolean> getDisableFragmentGetContextFix() {
      return Collections.<Boolean>emptySet();
    }

    @Override
    public ActivityRetainedComponentBuilder retainedComponentBuilder() {
      return new ActivityRetainedCBuilder(singletonCImpl);
    }

    @Override
    public ServiceComponentBuilder serviceComponentBuilder() {
      return new ServiceCBuilder(singletonCImpl);
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final SingletonCImpl singletonCImpl;

      private final int id;

      SwitchingProvider(SingletonCImpl singletonCImpl, int id) {
        this.singletonCImpl = singletonCImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // com.budakattusante.data.preferences.SessionManager 
          return (T) new SessionManager(ApplicationContextModule_ProvideContextFactory.provideContext(singletonCImpl.applicationContextModule));

          case 1: // com.budakattusante.data.repository.UserRepository 
          return (T) new UserRepository(singletonCImpl.userDao());

          case 2: // com.budakattusante.data.db.AppDatabase 
          return (T) AppModule_ProvideDatabaseFactory.provideDatabase(ApplicationContextModule_ProvideContextFactory.provideContext(singletonCImpl.applicationContextModule));

          case 3: // com.budakattusante.data.repository.OrderRepository 
          return (T) new OrderRepository(singletonCImpl.orderDao());

          case 4: // com.budakattusante.data.repository.ProductRepository 
          return (T) new ProductRepository(singletonCImpl.productDao(), singletonCImpl.tribalFamilyDao());

          default: throw new AssertionError(id);
        }
      }
    }
  }
}
