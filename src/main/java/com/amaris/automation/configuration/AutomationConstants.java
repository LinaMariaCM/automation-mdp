package com.amaris.automation.configuration;

public class AutomationConstants {

	public static final String RESULT = "result";
	
	public static final String TEST_SUCCESS = "SUCCESS";
	public static final String TEST_FAILURE = "FAILURE";
	public static final String TEST_UNDONE = "NOT EXECUTED";

	public static final String MODIFIED_DATA_INITIAL_VALUE = "NOT_MODIFIED";
	public static final String TEST_XML_PATH = "src/test/java/testng.xml";
	public static final String EXCEPTIONS_FOLDER = "exceptions/";
	public static final String REPORTS_FOLDER = "reports/";
	public static final String IMAGES_FOLDER = "images/";
	public static final String DEBUG_IMAGES_FOLDER = "debug images/";
	public static final String THUMBNAILS_FOLDER = "thumbnails/";
	public static final String RESOURCES_FOLDER = "resources/";

	public static final String INT_ENVIRONMENT = "INT";
	public static final String PRU_STAGE_ENVIRONMENT = "PRU";
	public static final String STAGE_ENVIRONTMENT = "STAGE";
	public static final String PRO_ENVIRONMENT = "PRO";

	public static final String LINUX_PATH_FOR_MAVEN = "/var/lib/jenkins/.m2/repository/webdriver/";
	public static final String WINDOWS_PATH_FOR_MAVEN = "/.m2/repository/webdriver/";

	public static final String EQUAL = "equal";
	public static final String NOT_EQUAL = "not equal";

	public static final String TESTCASE_REPLACE = "[TESTCASE]";
	
	public static final String SUITE_DATA = "suite_data";
	public static final String GLOBAL_DATA = "global_data";
	public static final String SCENARIO_DATA = "scenario_data";
	public static final String TEST_DATA = "test_data";
	public static final String CONFIGURATION_DATA = "configuration";

	public static final String SCENARIO_DATA_SET = "scenarioData.csv";
	public static final String GLOBAL_DATA_SET = "globalData";

	public static final String REPORTING_LVL_VERBOSE = "verbose";
	public static final String REPORTING_LVL_NORMAL = "normal";

	public static final String MAIN_DRIVER = "main_driver";
	public static final String PROJECT_ID = "project_id";

	// Driver type
	public static final String WEB = "WEB";
	public static final String MOBILE_WEB = "MOBILE_WEB";
	public static final String MOBILE_APP = "MOBILE_APP";

	// Configuration file variable names
	public static final String APP_PACKAGE = "app_package";

	public static final String REPORTING_LVL = "reporting_level";

	public static final String API_URL = "api_url";
	public static final String GET_CSV = "get_csv";
	public static final String SEND_CSV = "send_csv";
	public static final String SEND_IMG = "send_img";

	public static final String EXECUTION_FILTER = "execution_filter";
	public static final String TEST_FILTER = "test_filter";

	public static final String TEST_ID = "test_id";
	public static final String REPORT_PATH = "report_path";
	public static final String RETRY_ON_FAIL = "retry";
	public static final String MAX_TRIES = "max_tries";
	public static final String BUILD_GROUP = "build_group";
	public static final String SPECIAL_CASE = "special_case";

	public static final String BROWSER = "browser";
	public static final String TIMEOUT = "timeout";
	public static final String REMOTE_MODE = "remote";
	public static final String FORCE_CACHE = "force_cache";
	public static final String DRIVER_DOWNLOAD = "download";
	public static final String DRIVER_PLUGINS = "driver_plugins";
	public static final String MAXIMIZE_ON_START = "maximize";
	public static final String WINDOW_HEIGHT = "window_height";
	public static final String WINDOW_WIDTH = "window_width";
	public static final String SMALL_WINDOW_LIMIT = "small_window_limit";
	public static final String SHOW_CONSOLE_LOG = "show_console_log";
	public static final String DRIVER_LANGUAGE = "language";
	public static final String MOBILE_LANGUAGE = "mobile_language";
	public static final String EMULATION_BROWSER = "emulation_browser";
	public static final String ANDROID_EMULATOR = "android_emulator";
	public static final String PLATFORM = "platform";
	public static final String PLATFORM_NAME = "platformName";
	public static final String DEVICE = "device";
	public static final String DEVICE_NAME = "device_name";
	public static final String DEVICE_VERSION = "device_version";
	public static final String USE_PROXY = "use_proxy";

	public static final String SESSION_ID = "session_id";
	public static final String IP = "ip";
	public static final String PORT = "port";
	public static final String MOBILE_PORT = "mobile_port";

	public static final String WAIT_FOR_PAGE = "wait_for_page";
	public static final String WAIT_FOR_ANGULAR = "wait_for_angular";
	public static final String WAIT_FOR_JQUERY = "wait_for_jquery";
	public static final String IMPLICIT_WAIT = "implicit_wait";
	public static final String PAGE_LOAD_WAIT = "page_load_wait";
	public static final String SCRIPT_WAIT = "script_wait";

	public static final String MACOS_PREVIEW = "macos_preview";

	private AutomationConstants() {}
}
