package pl.senla.hotel.constant;

public class DaoConstant {

    private DaoConstant() {
    }

    public static final String CREATE_GENERIC_DAO = "CONSTRUCTOR: Built GenericDaoDB for {}";
    public static final String START_METHOD_READ_ALL = "START: GenericDaoDB method 'ReadAll'";
    public static final String START_METHOD_CREATE = "START: GenericDaoDB method 'Create'";
    public static final String START_METHOD_READ = "START: GenericDaoDB method 'Read'";
    public static final String START_METHOD_UPDATE = "START: GenericDaoDB method 'Update'";
    public static final String START_METHOD_DELETE = "START: GenericDaoDB method 'Delete'";

    public static final String START_METHOD_GET_ENTITY = "START: Get instance from ResultSet.";
    public static final String START_METHOD_GET_GETTER = "START: Get getter from ResultSet.";
    public static final String START_METHOD_BUILD_STRING_TO_CREATE = "START: Create PreparedStatement for CreateInstance.";
    public static final String START_METHOD_BUILD_STRING_TO_UPDATE = "START: Create PreparedStatement for UpdateInstance.";
    public static final String START_METHOD_SET_FIELD_VALUES_TO_STATEMENT = "START: Create set values to PreparedStatement.";
    public static final String ERROR_METHOD_SET_FIELD_VALUES_TO_STATEMENT = "ERROR in setFieldsValuesToCreateInstance.";
    public static final String ERROR_METHOD_SET_VALUES_TO_STATEMENT = "ERROR in setValuesToStatement.";
    public static final String ERROR_METHOD_GET_GETTER = "ERROR in getGetter.";

    public static final String GET_RESULT_SET = "Get ResultSet and start process it.";
    public static final String EXECUTE_REQUEST_TO_DB = "Execute Request to DB.";
    public static final String GET_FIELDS = "Get instance's fields.";
    public static final String SET_VALUE_ENUM = "Set Enum value to field.";
    public static final String SET_VALUE_INTEGER = "Set Integer value to field.";
    public static final String SET_VALUE_STRING = "Set String value to field.";
    public static final String SET_VALUE_TIMESTAMP = "Set Timestamp value to field.";
    public static final String WARN_ADD_NEW_METHOD = "No such type of fields in Application {}.\n" +
            "New type must be added to Application.";

    // SQL scripts
    public static final String SELECT_ALL_FIELDS = "SELECT * FROM ";
    public static final String WHERE = " WHERE ";
    public static final String SET = " SET ";
    public static final String REQUEST_VALUE = "=?";
    public static final String DELETE_FROM = "DELETE FROM ";
    public static final String INSERT_INTO = "INSERT INTO ";
    public static final String UPDATE = "UPDATE ";
    public static final String TABLE_NAME = "tableName";

}
