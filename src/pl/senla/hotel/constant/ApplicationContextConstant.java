package pl.senla.hotel.constant;

public class ApplicationContextConstant {

    private ApplicationContextConstant() {
    }

    public static final String START_APPLICATION =          "Start Application.";
    public static final String CLOSE_APPLICATION =          "Good-bye.";

    // Application, Context and DI
    public static final String CRATE_APPLICATION_LOADER =   "Create Application's loading instance.";
    public static final String RUN_APPLICATION =            "Run Application.";
    public static final String INVOKE_START_METHOD =        "Invoke Start method.";
    public static final String ERROR_NO_START_METHOD =      "Application doesn't have StartPoint or StartMethod!";
    public static final String START_CREATE_CONTEXT =       "Start creating of Application's context.";
    public static final String CONTEXT_IS_READY =           "Context is ready to use.";
    public static final String SET_VALUE_FROM_PROPERTIES =  "Set value of {} from Properties";
    public static final String ADD_BEAN_TO_CONTAINER =      "Class {} and his Bean have been added to DIContainer!";
    public static final String NO_BEAN_IN_CONTAINER =       "There is no {} in DIContainer";

    // AnnotationScanner:
    public static final String GET_ANNOTATION_CONFIG_PROPERTY = "getFieldsAnnotatedWith(ConfigProperty.class)";
    public static final String GET_ANNOTATION_APP_COMPONENT =   "getTypesAnnotatedWith(AppComponent.class)";
    public static final String GET_ANNOTATION_START_POINT =     "getTypesAnnotatedWith(StartPoint.class)";
    public static final String GET_ANNOTATION_GET_INSTANCE =    "getFieldsAnnotatedWith(GetInstance.class)";
    public static final String GET_ANNOTATION_ENTITY =          "getTypesAnnotatedWith(Entity.class)";
    public static final String CREATE_CONFIG_PROPERTIES =       "Create ConfigProperties.";


}
