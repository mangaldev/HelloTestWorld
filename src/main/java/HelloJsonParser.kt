import com.jayway.jsonpath.JsonPath

/**
   * Created by mdev on 5/14/17.
  */
 object HelloJsonParser {

internal var json = "{\n" +
"  \"availability_day\": null, \n" +
"  \"availability_manifest\": null, \n" +
"  \"catalog_item\": [], \n" +
"  \"catalog_manifest\": null, \n" +
"  \"cdate\": null, \n" +
"  \"contributor_contexts\": null, \n" +
"  \"cuser\": null, \n" +
"  \"deprecated_by_id\": null, \n" +
"  \"entitled_countries\": null, \n" +
"  \"hash\": null, \n" +
"  \"id\": \"GN7JAQT4YXNNCXS\", \n" +
"  \"lineup_provider\": null, \n" +
"  \"media_contexts\": null, \n" +
"  \"object_type_id\": \"Program\", \n" +
"  \"program_contexts\": {\n" +
"    \"program_context\": [\n" +
"      {\n" +
"        \"associated_parties\": null, \n" +
"        \"awards\": null, \n" +
"        \"cast_credits\": null, \n" +
"        \"context_ids\": {\n" +
"          \"context_id\": [\n" +
"            \"CTX_CL_USA_es\"\n" +
"          ]\n" +
"        }, \n" +
"        \"countries_of_origin\": {\n" +
"          \"country_of_origin\": [\n" +
"            {\n" +
"              \"ord\": null, \n" +
"              \"property_subtype_id\": null, \n" +
"              \"property_type_id\": \"CTR_USA\", \n" +
"              \"property_value\": null\n" +
"            }\n" +
"          ]\n" +
"        }, \n" +
"        \"crew_credits\": null, \n" +
"        \"descriptions\": {\n" +
"          \"description\": [\n" +
"            {\n" +
"              \"copyright\": null, \n" +
"              \"extended_attributes\": null, \n" +
"              \"id\": null, \n" +
"              \"length\": 194, \n" +
"              \"rights_holder\": null, \n" +
"              \"status_id\": null, \n" +
"              \"subtype_id\": null, \n" +
"              \"text\": \"Registros en el cuadril\\u00e1tero, la vida familiar y celebridad del boxeador est\\u00e1n documentados en fragmentos de pel\\u00edculas y entrevistas con Woody Allen, Dave Anderson, Jack Newfield y Jake LaMotta.\", \n" +
"              \"type_id\": \"DES_PLOT250\"\n" +
"            }, \n" +
"            {\n" +
"              \"copyright\": null, \n" +
"              \"extended_attributes\": null, \n" +
"              \"id\": null, \n" +
"              \"length\": 60, \n" +
"              \"rights_holder\": null, \n" +
"              \"status_id\": null, \n" +
"              \"subtype_id\": null, \n" +
"              \"text\": \"Registros en el cuadril\\u00e1tero, la vida familiar y celebridad.\", \n" +
"              \"type_id\": \"DES_PLOT60\"\n" +
"            }, \n" +
"            {\n" +
"              \"copyright\": null, \n" +
"              \"extended_attributes\": null, \n" +
"              \"id\": null, \n" +
"              \"length\": 34, \n" +
"              \"rights_holder\": null, \n" +
"              \"status_id\": null, \n" +
"              \"subtype_id\": null, \n" +
"              \"text\": \"Registros en el ring del boxeador.\", \n" +
"              \"type_id\": \"DES_PLOT40\"\n" +
"            }\n" +
"          ]\n" +
"        }, \n" +
"        \"duration_block\": {\n" +
"          \"duration\": \"3540\", \n" +
"          \"duration_units\": \"seconds\", \n" +
"          \"end_date\": null, \n" +
"          \"relevant_year\": null, \n" +
"          \"start_date\": null\n" +
"        }, \n" +
"        \"episode\": null, \n" +
"        \"events\": {\n" +
"          \"event\": [\n" +
"            {\n" +
"              \"event_date\": {\n" +
"                \"duration\": null, \n" +
"                \"duration_units\": null, \n" +
"                \"end_date\": null, \n" +
"                \"relevant_year\": null, \n" +
"                \"start_date\": 913075200000\n" +
"              }, \n" +
"              \"extended_attributes\": null, \n" +
"              \"id\": null, \n" +
"              \"status_id\": null, \n" +
"              \"subtype_id\": null, \n" +
"              \"type_id\": \"EVT_ORIGINAL_AIR_DATE\"\n" +
"            }, \n" +
"            {\n" +
"              \"event_date\": null, \n" +
"              \"extended_attributes\": null, \n" +
"              \"id\": null, \n" +
"              \"status_id\": null, \n" +
"              \"subtype_id\": null, \n" +
"              \"type_id\": null\n" +
"            }\n" +
"          ]\n" +
"        }, \n" +
"        \"extended_attributes\": null, \n" +
"        \"genres\": {\n" +
"          \"genre\": [\n" +
"            {\n" +
"              \"ord\": \"2\", \n" +
"              \"property_subtype_id\": \"Boxing\", \n" +
"              \"property_type_id\": \"SPORTS\", \n" +
"              \"property_value\": null\n" +
"            }, \n" +
"            {\n" +
"              \"ord\": \"1\", \n" +
"              \"property_subtype_id\": \"Documentary\", \n" +
"              \"property_type_id\": \"DOCUMENTARY\", \n" +
"              \"property_value\": null\n" +
"            }, \n" +
"            {\n" +
"              \"ord\": \"0\", \n" +
"              \"property_subtype_id\": \"New Reports\", \n" +
"              \"property_type_id\": \"SPORTS\", \n" +
"              \"property_value\": null\n" +
"            }\n" +
"          ]\n" +
"        }, \n" +
"        \"id\": \"GN9NP7NP4MBSSTP\", \n" +
"        \"keywords\": null, \n" +
"        \"media\": {\n" +
"          \"medium\": [\n" +
"            {\n" +
"              \"copyright\": null, \n" +
"              \"dimensions\": null, \n" +
"              \"duration\": null, \n" +
"              \"extended_attributes\": null, \n" +
"              \"id\": \"GN5XTA0AZVMGXGD\", \n" +
"              \"rights_holder\": null, \n" +
"              \"status_id\": null, \n" +
"              \"subtype_id\": null, \n" +
"              \"type_id\": null, \n" +
"              \"uri\": null, \n" +
"              \"xids\": null\n" +
"            }, \n" +
"            {\n" +
"              \"copyright\": null, \n" +
"              \"dimensions\": null, \n" +
"              \"duration\": null, \n" +
"              \"extended_attributes\": null, \n" +
"              \"id\": \"GN0MHMSRQKQ8RX7\", \n" +
"              \"rights_holder\": null, \n" +
"              \"status_id\": null, \n" +
"              \"subtype_id\": null, \n" +
"              \"type_id\": null, \n" +
"              \"uri\": null, \n" +
"              \"xids\": null\n" +
"            }, \n" +
"            {\n" +
"              \"copyright\": null, \n" +
"              \"dimensions\": null, \n" +
"              \"duration\": null, \n" +
"              \"extended_attributes\": null, \n" +
"              \"id\": \"GNFQH6D61YVB1WE\", \n" +
"              \"rights_holder\": null, \n" +
"              \"status_id\": null, \n" +
"              \"subtype_id\": null, \n" +
"              \"type_id\": null, \n" +
"              \"uri\": null, \n" +
"              \"xids\": null\n" +
"            }, \n" +
"            {\n" +
"              \"copyright\": null, \n" +
"              \"dimensions\": null, \n" +
"              \"duration\": null, \n" +
"              \"extended_attributes\": null, \n" +
"              \"id\": \"GN4QW0VPZ9ZFB6R\", \n" +
"              \"rights_holder\": null, \n" +
"              \"status_id\": null, \n" +
"              \"subtype_id\": null, \n" +
"              \"type_id\": null, \n" +
"              \"uri\": null, \n" +
"              \"xids\": null\n" +
"            }, \n" +
"            {\n" +
"              \"copyright\": null, \n" +
"              \"dimensions\": null, \n" +
"              \"duration\": null, \n" +
"              \"extended_attributes\": null, \n" +
"              \"id\": \"GN9FSQTQVW5BC6J\", \n" +
"              \"rights_holder\": null, \n" +
"              \"status_id\": null, \n" +
"              \"subtype_id\": null, \n" +
"              \"type_id\": null, \n" +
"              \"uri\": null, \n" +
"              \"xids\": null\n" +
"            }, \n" +
"            {\n" +
"              \"copyright\": null, \n" +
"              \"dimensions\": null, \n" +
"              \"duration\": null, \n" +
"              \"extended_attributes\": null, \n" +
"              \"id\": \"GN99QCBQZXRBVB9\", \n" +
"              \"rights_holder\": null, \n" +
"              \"status_id\": null, \n" +
"              \"subtype_id\": null, \n" +
"              \"type_id\": null, \n" +
"              \"uri\": null, \n" +
"              \"xids\": null\n" +
"            }, \n" +
"            {\n" +
"              \"copyright\": null, \n" +
"              \"dimensions\": null, \n" +
"              \"duration\": null, \n" +
"              \"extended_attributes\": null, \n" +
"              \"id\": \"GNC8Z1PW8QSM9Y0\", \n" +
"              \"rights_holder\": null, \n" +
"              \"status_id\": null, \n" +
"              \"subtype_id\": null, \n" +
"              \"type_id\": null, \n" +
"              \"uri\": null, \n" +
"              \"xids\": null\n" +
"            }, \n" +
"            {\n" +
"              \"copyright\": null, \n" +
"              \"dimensions\": null, \n" +
"              \"duration\": null, \n" +
"              \"extended_attributes\": null, \n" +
"              \"id\": \"GN90QWD07317XWC\", \n" +
"              \"rights_holder\": null, \n" +
"              \"status_id\": null, \n" +
"              \"subtype_id\": null, \n" +
"              \"type_id\": null, \n" +
"              \"uri\": null, \n" +
"              \"xids\": null\n" +
"            }, \n" +
"            {\n" +
"              \"copyright\": null, \n" +
"              \"dimensions\": null, \n" +
"              \"duration\": null, \n" +
"              \"extended_attributes\": null, \n" +
"              \"id\": \"GN62KXARMPC3QPJ\", \n" +
"              \"rights_holder\": null, \n" +
"              \"status_id\": null, \n" +
"              \"subtype_id\": null, \n" +
"              \"type_id\": null, \n" +
"              \"uri\": null, \n" +
"              \"xids\": null\n" +
"            }, \n" +
"            {\n" +
"              \"copyright\": null, \n" +
"              \"dimensions\": null, \n" +
"              \"duration\": null, \n" +
"              \"extended_attributes\": null, \n" +
"              \"id\": \"GN1SJ4837RYBHAR\", \n" +
"              \"rights_holder\": null, \n" +
"              \"status_id\": null, \n" +
"              \"subtype_id\": null, \n" +
"              \"type_id\": null, \n" +
"              \"uri\": null, \n" +
"              \"xids\": null\n" +
"            }, \n" +
"            {\n" +
"              \"copyright\": null, \n" +
"              \"dimensions\": null, \n" +
"              \"duration\": null, \n" +
"              \"extended_attributes\": null, \n" +
"              \"id\": \"GN5JWZYX05ZX87P\", \n" +
"              \"rights_holder\": null, \n" +
"              \"status_id\": null, \n" +
"              \"subtype_id\": null, \n" +
"              \"type_id\": null, \n" +
"              \"uri\": null, \n" +
"              \"xids\": null\n" +
"            }, \n" +
"            {\n" +
"              \"copyright\": null, \n" +
"              \"dimensions\": null, \n" +
"              \"duration\": null, \n" +
"              \"extended_attributes\": null, \n" +
"              \"id\": \"GNAW8G7CX6CPTFZ\", \n" +
"              \"rights_holder\": null, \n" +
"              \"status_id\": null, \n" +
"              \"subtype_id\": null, \n" +
"              \"type_id\": null, \n" +
"              \"uri\": null, \n" +
"              \"xids\": null\n" +
"            }, \n" +
"            {\n" +
"              \"copyright\": null, \n" +
"              \"dimensions\": null, \n" +
"              \"duration\": null, \n" +
"              \"extended_attributes\": null, \n" +
"              \"id\": \"GN1RVGH5ZKE34PJ\", \n" +
"              \"rights_holder\": null, \n" +
"              \"status_id\": null, \n" +
"              \"subtype_id\": null, \n" +
"              \"type_id\": null, \n" +
"              \"uri\": null, \n" +
"              \"xids\": null\n" +
"            }, \n" +
"            {\n" +
"              \"copyright\": null, \n" +
"              \"dimensions\": null, \n" +
"              \"duration\": null, \n" +
"              \"extended_attributes\": null, \n" +
"              \"id\": \"GN40D4DT9Z2XEBT\", \n" +
"              \"rights_holder\": null, \n" +
"              \"status_id\": null, \n" +
"              \"subtype_id\": null, \n" +
"              \"type_id\": null, \n" +
"              \"uri\": null, \n" +
"              \"xids\": null\n" +
"            }, \n" +
"            {\n" +
"              \"copyright\": null, \n" +
"              \"dimensions\": null, \n" +
"              \"duration\": null, \n" +
"              \"extended_attributes\": null, \n" +
"              \"id\": \"GN9R3NGDWN48JYQ\", \n" +
"              \"rights_holder\": null, \n" +
"              \"status_id\": null, \n" +
"              \"subtype_id\": null, \n" +
"              \"type_id\": null, \n" +
"              \"uri\": null, \n" +
"              \"xids\": null\n" +
"            }, \n" +
"            {\n" +
"              \"copyright\": null, \n" +
"              \"dimensions\": null, \n" +
"              \"duration\": null, \n" +
"              \"extended_attributes\": null, \n" +
"              \"id\": \"GNBBQHQE1PCWGXD\", \n" +
"              \"rights_holder\": null, \n" +
"              \"status_id\": null, \n" +
"              \"subtype_id\": null, \n" +
"              \"type_id\": null, \n" +
"              \"uri\": null, \n" +
"              \"xids\": null\n" +
"            }, \n" +
"            {\n" +
"              \"copyright\": null, \n" +
"              \"dimensions\": null, \n" +
"              \"duration\": null, \n" +
"              \"extended_attributes\": null, \n" +
"              \"id\": \"GN0Z3MJ8FCBMXDT\", \n" +
"              \"rights_holder\": null, \n" +
"              \"status_id\": null, \n" +
"              \"subtype_id\": null, \n" +
"              \"type_id\": null, \n" +
"              \"uri\": null, \n" +
"              \"xids\": null\n" +
"            }, \n" +
"            {\n" +
"              \"copyright\": null, \n" +
"              \"dimensions\": null, \n" +
"              \"duration\": null, \n" +
"              \"extended_attributes\": null, \n" +
"              \"id\": \"GNDPKBD8MRE0E5Q\", \n" +
"              \"rights_holder\": null, \n" +
"              \"status_id\": null, \n" +
"              \"subtype_id\": null, \n" +
"              \"type_id\": null, \n" +
"              \"uri\": null, \n" +
"              \"xids\": null\n" +
"            }\n" +
"          ]\n" +
"        }, \n" +
"        \"ratings\": {\n" +
"          \"rating\": [\n" +
"            {\n" +
"              \"ord\": null, \n" +
"              \"property_subtype_id\": \"RTG_USA_04_04\", \n" +
"              \"property_type_id\": \"RTG_USA_04\", \n" +
"              \"property_value\": null\n" +
"            }\n" +
"          ]\n" +
"        }, \n" +
"        \"season\": null, \n" +
"        \"series\": null, \n" +
"        \"status_id\": \"active\", \n" +
"        \"subtype_id\": \"OTHER_SPECIAL\", \n" +
"        \"titles\": {\n" +
"          \"title\": [\n" +
"            {\n" +
"              \"copyright\": null, \n" +
"              \"extended_attributes\": null, \n" +
"              \"id\": null, \n" +
"              \"length\": 68, \n" +
"              \"rights_holder\": null, \n" +
"              \"status_id\": null, \n" +
"              \"subtype_id\": \"TTL_MAIN\", \n" +
"              \"text\": \"Sugar Ray Robinson: The Bright Lights and Dark Shadows of a Champion\", \n" +
"              \"type_id\": \"TTL_PRIMARY\"\n" +
"            }, \n" +
"            {\n" +
"              \"copyright\": null, \n" +
"              \"extended_attributes\": null, \n" +
"              \"id\": null, \n" +
"              \"length\": 18, \n" +
"              \"rights_holder\": null, \n" +
"              \"status_id\": null, \n" +
"              \"subtype_id\": \"TTL_MAIN\", \n" +
"              \"text\": \"Sugar Ray Robinson\", \n" +
"              \"type_id\": \"TTL_REDUCED\"\n" +
"            }, \n" +
"            {\n" +
"              \"copyright\": null, \n" +
"              \"extended_attributes\": null, \n" +
"              \"id\": null, \n" +
"              \"length\": 12, \n" +
"              \"rights_holder\": null, \n" +
"              \"status_id\": null, \n" +
"              \"subtype_id\": \"TTL_MAIN\", \n" +
"              \"text\": \"Ray Robinson\", \n" +
"              \"type_id\": \"TTL_REDUCED\"\n" +
"            }, \n" +
"            {\n" +
"              \"copyright\": null, \n" +
"              \"extended_attributes\": null, \n" +
"              \"id\": null, \n" +
"              \"length\": 11, \n" +
"              \"rights_holder\": null, \n" +
"              \"status_id\": null, \n" +
"              \"subtype_id\": \"TTL_MAIN\", \n" +
"              \"text\": \"R. Robinson\", \n" +
"              \"type_id\": \"TTL_REDUCED\"\n" +
"            }, \n" +
"            {\n" +
"              \"copyright\": null, \n" +
"              \"extended_attributes\": null, \n" +
"              \"id\": null, \n" +
"              \"length\": 36, \n" +
"              \"rights_holder\": null, \n" +
"              \"status_id\": null, \n" +
"              \"subtype_id\": \"TTL_MAIN\", \n" +
"              \"text\": \"Sugar Ray Robinson: Lights & Shadows\", \n" +
"              \"type_id\": \"TTL_REDUCED\"\n" +
"            }, \n" +
"            {\n" +
"              \"copyright\": null, \n" +
"              \"extended_attributes\": null, \n" +
"              \"id\": null, \n" +
"              \"length\": 50, \n" +
"              \"rights_holder\": null, \n" +
"              \"status_id\": null, \n" +
"              \"subtype_id\": \"TTL_MAIN\", \n" +
"              \"text\": \"Sugar Ray Robinson: Lights & Shadows of a Champion\", \n" +
"              \"type_id\": \"TTL_REDUCED\"\n" +
"            }, \n" +
"            {\n" +
"              \"copyright\": null, \n" +
"              \"extended_attributes\": null, \n" +
"              \"id\": null, \n" +
"              \"length\": 28, \n" +
"              \"rights_holder\": null, \n" +
"              \"status_id\": null, \n" +
"              \"subtype_id\": \"TTL_MAIN\", \n" +
"              \"text\": \"Sugar Ray Robinson: Champion\", \n" +
"              \"type_id\": \"TTL_REDUCED\"\n" +
"            }, \n" +
"            {\n" +
"              \"copyright\": null, \n" +
"              \"extended_attributes\": null, \n" +
"              \"id\": null, \n" +
"              \"length\": 62, \n" +
"              \"rights_holder\": null, \n" +
"              \"status_id\": null, \n" +
"              \"subtype_id\": \"TTL_MAIN\", \n" +
"              \"text\": \"Sugar Ray Robinson: Bright Lights & Dark Shadows of a Champion\", \n" +
"              \"type_id\": \"TTL_REDUCED\"\n" +
"            }, \n" +
"            {\n" +
"              \"copyright\": null, \n" +
"              \"extended_attributes\": null, \n" +
"              \"id\": null, \n" +
"              \"length\": 5, \n" +
"              \"rights_holder\": null, \n" +
"              \"status_id\": null, \n" +
"              \"subtype_id\": \"TTL_MAIN\", \n" +
"              \"text\": \"Sugar\", \n" +
"              \"type_id\": \"TTL_REDUCED\"\n" +
"            }\n" +
"          ]\n" +
"        }, \n" +
"        \"type_id\": \"SHOWS\", \n" +
"        \"uris\": null, \n" +
"        \"warnings\": null, \n" +
"        \"xids\": {\n" +
"          \"xid\": [\n" +
"            {\n" +
"              \"extended_attributes\": null, \n" +
"              \"id\": \"495619\", \n" +
"              \"status_id\": null, \n" +
"              \"subtype_id\": null, \n" +
"              \"type_id\": \"root_id\", \n" +
"              \"vendor_id\": \"TMS\"\n" +
"            }, \n" +
"            {\n" +
"              \"extended_attributes\": null, \n" +
"              \"id\": \"15843563\", \n" +
"              \"status_id\": null, \n" +
"              \"subtype_id\": null, \n" +
"              \"type_id\": \"version_mapping_id\", \n" +
"              \"vendor_id\": \"TMS\"\n" +
"            }, \n" +
"            {\n" +
"              \"extended_attributes\": null, \n" +
"              \"id\": null, \n" +
"              \"status_id\": null, \n" +
"              \"subtype_id\": null, \n" +
"              \"type_id\": \"parent_tms_id\", \n" +
"              \"vendor_id\": \"TMS\"\n" +
"            }, \n" +
"            {\n" +
"              \"extended_attributes\": null, \n" +
"              \"id\": \"SH019294290000\", \n" +
"              \"status_id\": null, \n" +
"              \"subtype_id\": null, \n" +
"              \"type_id\": \"tms_id\", \n" +
"              \"vendor_id\": \"TMS\"\n" +
"            }, \n" +
"            {\n" +
"              \"extended_attributes\": null, \n" +
"              \"id\": \"568277\", \n" +
"              \"status_id\": null, \n" +
"              \"subtype_id\": null, \n" +
"              \"type_id\": \"titleset_id\", \n" +
"              \"vendor_id\": \"TMS\"\n" +
"            }\n" +
"          ]\n" +
"        }\n" +
"      }, \n" +
"      {\n" +
"        \"associated_parties\": null, \n" +
"        \"awards\": null, \n" +
"        \"cast_credits\": null, \n" +
"        \"context_ids\": {\n" +
"          \"context_id\": [\n" +
"            \"CTX_L_en\"\n" +
"          ]\n" +
"        }, \n" +
"        \"countries_of_origin\": {\n" +
"          \"country_of_origin\": [\n" +
"            {\n" +
"              \"ord\": null, \n" +
"              \"property_subtype_id\": null, \n" +
"              \"property_type_id\": \"CTR_USA\", \n" +
"              \"property_value\": null\n" +
"            }\n" +
"          ]\n" +
"        }, \n" +
"        \"crew_credits\": null, \n" +
"        \"descriptions\": {\n" +
"          \"description\": [\n" +
"            {\n" +
"              \"copyright\": null, \n" +
"              \"extended_attributes\": null, \n" +
"              \"id\": null, \n" +
"              \"length\": 51, \n" +
"              \"rights_holder\": null, \n" +
"              \"status_id\": null, \n" +
"              \"subtype_id\": null, \n" +
"              \"text\": \"The boxer's ring record, family life and celebrity.\", \n" +
"              \"type_id\": \"DES_PLOT60\"\n" +
"            }, \n" +
"            {\n" +
"              \"copyright\": null, \n" +
"              \"extended_attributes\": null, \n" +
"              \"id\": null, \n" +
"              \"length\": 31, \n" +
"              \"rights_holder\": null, \n" +
"              \"status_id\": null, \n" +
"              \"subtype_id\": null, \n" +
"              \"text\": \"Boxer's ring record, celebrity.\", \n" +
"              \"type_id\": \"DES_PLOT40\"\n" +
"            }, \n" +
"            {\n" +
"              \"copyright\": null, \n" +
"              \"extended_attributes\": null, \n" +
"              \"id\": null, \n" +
"              \"length\": 159, \n" +
"              \"rights_holder\": null, \n" +
"              \"status_id\": null, \n" +
"              \"subtype_id\": null, \n" +
"              \"text\": \"The boxer's ring record, family life and celebrity are documented in film clips and interviews with Woody Allen, Dave Anderson, Jack Newfield and Jake LaMotta.\", \n" +
"              \"type_id\": \"DES_PLOT250\"\n" +
"            }\n" +
"          ]\n" +
"        }, \n" +
"        \"duration_block\": {\n" +
"          \"duration\": \"3540\", \n" +
"          \"duration_units\": \"seconds\", \n" +
"          \"end_date\": null, \n" +
"          \"relevant_year\": null, \n" +
"          \"start_date\": null\n" +
"        }, \n" +
"        \"episode\": null, \n" +
"        \"events\": {\n" +
"          \"event\": [\n" +
"            {\n" +
"              \"event_date\": {\n" +
"                \"duration\": null, \n" +
"                \"duration_units\": null, \n" +
"                \"end_date\": null, \n" +
"                \"relevant_year\": null, \n" +
"                \"start_date\": 913075200000\n" +
"              }, \n" +
"              \"extended_attributes\": null, \n" +
"              \"id\": null, \n" +
"              \"status_id\": null, \n" +
"              \"subtype_id\": null, \n" +
"              \"type_id\": \"EVT_ORIGINAL_AIR_DATE\"\n" +
"            }, \n" +
"            {\n" +
"              \"event_date\": null, \n" +
"              \"extended_attributes\": null, \n" +
"              \"id\": null, \n" +
"              \"status_id\": null, \n" +
"              \"subtype_id\": null, \n" +
"              \"type_id\": null\n" +
"            }\n" +
"          ]\n" +
"        }, \n" +
"        \"extended_attributes\": null, \n" +
"        \"genres\": {\n" +
"          \"genre\": [\n" +
"            {\n" +
"              \"ord\": \"2\", \n" +
"              \"property_subtype_id\": \"Boxing\", \n" +
"              \"property_type_id\": \"SPORTS\", \n" +
"              \"property_value\": null\n" +
"            }, \n" +
"            {\n" +
"              \"ord\": \"1\", \n" +
"              \"property_subtype_id\": \"Documentary\", \n" +
"              \"property_type_id\": \"DOCUMENTARY\", \n" +
"              \"property_value\": null\n" +
"            }, \n" +
"            {\n" +
"              \"ord\": \"0\", \n" +
"              \"property_subtype_id\": \"New Reports\", \n" +
"              \"property_type_id\": \"SPORTS\", \n" +
"              \"property_value\": null\n" +
"            }\n" +
"          ]\n" +
"        }, \n" +
"        \"id\": \"GNC0QVFPHCNZRC8\", \n" +
"        \"keywords\": null, \n" +
"        \"media\": {\n" +
"          \"medium\": [\n" +
"            {\n" +
"              \"copyright\": null, \n" +
"              \"dimensions\": null, \n" +
"              \"duration\": null, \n" +
"              \"extended_attributes\": null, \n" +
"              \"id\": \"GN5XTA0AZVMGXGD\", \n" +
"              \"rights_holder\": null, \n" +
"              \"status_id\": null, \n" +
"              \"subtype_id\": null, \n" +
"              \"type_id\": null, \n" +
"              \"uri\": null, \n" +
"              \"xids\": null\n" +
"            }, \n" +
"            {\n" +
"              \"copyright\": null, \n" +
"              \"dimensions\": null, \n" +
"              \"duration\": null, \n" +
"              \"extended_attributes\": null, \n" +
"              \"id\": \"GN0MHMSRQKQ8RX7\", \n" +
"              \"rights_holder\": null, \n" +
"              \"status_id\": null, \n" +
"              \"subtype_id\": null, \n" +
"              \"type_id\": null, \n" +
"              \"uri\": null, \n" +
"              \"xids\": null\n" +
"            }, \n" +
"            {\n" +
"              \"copyright\": null, \n" +
"              \"dimensions\": null, \n" +
"              \"duration\": null, \n" +
"              \"extended_attributes\": null, \n" +
"              \"id\": \"GNFQH6D61YVB1WE\", \n" +
"              \"rights_holder\": null, \n" +
"              \"status_id\": null, \n" +
"              \"subtype_id\": null, \n" +
"              \"type_id\": null, \n" +
"              \"uri\": null, \n" +
"              \"xids\": null\n" +
"            }, \n" +
"            {\n" +
"              \"copyright\": null, \n" +
"              \"dimensions\": null, \n" +
"              \"duration\": null, \n" +
"              \"extended_attributes\": null, \n" +
"              \"id\": \"GN4QW0VPZ9ZFB6R\", \n" +
"              \"rights_holder\": null, \n" +
"              \"status_id\": null, \n" +
"              \"subtype_id\": null, \n" +
"              \"type_id\": null, \n" +
"              \"uri\": null, \n" +
"              \"xids\": null\n" +
"            }, \n" +
"            {\n" +
"              \"copyright\": null, \n" +
"              \"dimensions\": null, \n" +
"              \"duration\": null, \n" +
"              \"extended_attributes\": null, \n" +
"              \"id\": \"GN9FSQTQVW5BC6J\", \n" +
"              \"rights_holder\": null, \n" +
"              \"status_id\": null, \n" +
"              \"subtype_id\": null, \n" +
"              \"type_id\": null, \n" +
"              \"uri\": null, \n" +
"              \"xids\": null\n" +
"            }, \n" +
"            {\n" +
"              \"copyright\": null, \n" +
"              \"dimensions\": null, \n" +
"              \"duration\": null, \n" +
"              \"extended_attributes\": null, \n" +
"              \"id\": \"GN99QCBQZXRBVB9\", \n" +
"              \"rights_holder\": null, \n" +
"              \"status_id\": null, \n" +
"              \"subtype_id\": null, \n" +
"              \"type_id\": null, \n" +
"              \"uri\": null, \n" +
"              \"xids\": null\n" +
"            }, \n" +
"            {\n" +
"              \"copyright\": null, \n" +
"              \"dimensions\": null, \n" +
"              \"duration\": null, \n" +
"              \"extended_attributes\": null, \n" +
"              \"id\": \"GNC8Z1PW8QSM9Y0\", \n" +
"              \"rights_holder\": null, \n" +
"              \"status_id\": null, \n" +
"              \"subtype_id\": null, \n" +
"              \"type_id\": null, \n" +
"              \"uri\": null, \n" +
"              \"xids\": null\n" +
"            }, \n" +
"            {\n" +
"              \"copyright\": null, \n" +
"              \"dimensions\": null, \n" +
"              \"duration\": null, \n" +
"              \"extended_attributes\": null, \n" +
"              \"id\": \"GN90QWD07317XWC\", \n" +
"              \"rights_holder\": null, \n" +
"              \"status_id\": null, \n" +
"              \"subtype_id\": null, \n" +
"              \"type_id\": null, \n" +
"              \"uri\": null, \n" +
"              \"xids\": null\n" +
"            }, \n" +
"            {\n" +
"              \"copyright\": null, \n" +
"              \"dimensions\": null, \n" +
"              \"duration\": null, \n" +
"              \"extended_attributes\": null, \n" +
"              \"id\": \"GN62KXARMPC3QPJ\", \n" +
"              \"rights_holder\": null, \n" +
"              \"status_id\": null, \n" +
"              \"subtype_id\": null, \n" +
"              \"type_id\": null, \n" +
"              \"uri\": null, \n" +
"              \"xids\": null\n" +
"            }, \n" +
"            {\n" +
"              \"copyright\": null, \n" +
"              \"dimensions\": null, \n" +
"              \"duration\": null, \n" +
"              \"extended_attributes\": null, \n" +
"              \"id\": \"GN1SJ4837RYBHAR\", \n" +
"              \"rights_holder\": null, \n" +
"              \"status_id\": null, \n" +
"              \"subtype_id\": null, \n" +
"              \"type_id\": null, \n" +
"              \"uri\": null, \n" +
"              \"xids\": null\n" +
"            }, \n" +
"            {\n" +
"              \"copyright\": null, \n" +
"              \"dimensions\": null, \n" +
"              \"duration\": null, \n" +
"              \"extended_attributes\": null, \n" +
"              \"id\": \"GN5JWZYX05ZX87P\", \n" +
"              \"rights_holder\": null, \n" +
"              \"status_id\": null, \n" +
"              \"subtype_id\": null, \n" +
"              \"type_id\": null, \n" +
"              \"uri\": null, \n" +
"              \"xids\": null\n" +
"            }, \n" +
"            {\n" +
"              \"copyright\": null, \n" +
"              \"dimensions\": null, \n" +
"              \"duration\": null, \n" +
"              \"extended_attributes\": null, \n" +
"              \"id\": \"GNAW8G7CX6CPTFZ\", \n" +
"              \"rights_holder\": null, \n" +
"              \"status_id\": null, \n" +
"              \"subtype_id\": null, \n" +
"              \"type_id\": null, \n" +
"              \"uri\": null, \n" +
"              \"xids\": null\n" +
"            }, \n" +
"            {\n" +
"              \"copyright\": null, \n" +
"              \"dimensions\": null, \n" +
"              \"duration\": null, \n" +
"              \"extended_attributes\": null, \n" +
"              \"id\": \"GN1RVGH5ZKE34PJ\", \n" +
"              \"rights_holder\": null, \n" +
"              \"status_id\": null, \n" +
"              \"subtype_id\": null, \n" +
"              \"type_id\": null, \n" +
"              \"uri\": null, \n" +
"              \"xids\": null\n" +
"            }, \n" +
"            {\n" +
"              \"copyright\": null, \n" +
"              \"dimensions\": null, \n" +
"              \"duration\": null, \n" +
"              \"extended_attributes\": null, \n" +
"              \"id\": \"GN40D4DT9Z2XEBT\", \n" +
"              \"rights_holder\": null, \n" +
"              \"status_id\": null, \n" +
"              \"subtype_id\": null, \n" +
"              \"type_id\": null, \n" +
"              \"uri\": null, \n" +
"              \"xids\": null\n" +
"            }, \n" +
"            {\n" +
"              \"copyright\": null, \n" +
"              \"dimensions\": null, \n" +
"              \"duration\": null, \n" +
"              \"extended_attributes\": null, \n" +
"              \"id\": \"GN9R3NGDWN48JYQ\", \n" +
"              \"rights_holder\": null, \n" +
"              \"status_id\": null, \n" +
"              \"subtype_id\": null, \n" +
"              \"type_id\": null, \n" +
"              \"uri\": null, \n" +
"              \"xids\": null\n" +
"            }, \n" +
"            {\n" +
"              \"copyright\": null, \n" +
"              \"dimensions\": null, \n" +
"              \"duration\": null, \n" +
"              \"extended_attributes\": null, \n" +
"              \"id\": \"GNBBQHQE1PCWGXD\", \n" +
"              \"rights_holder\": null, \n" +
"              \"status_id\": null, \n" +
"              \"subtype_id\": null, \n" +
"              \"type_id\": null, \n" +
"              \"uri\": null, \n" +
"              \"xids\": null\n" +
"            }, \n" +
"            {\n" +
"              \"copyright\": null, \n" +
"              \"dimensions\": null, \n" +
"              \"duration\": null, \n" +
"              \"extended_attributes\": null, \n" +
"              \"id\": \"GN0Z3MJ8FCBMXDT\", \n" +
"              \"rights_holder\": null, \n" +
"              \"status_id\": null, \n" +
"              \"subtype_id\": null, \n" +
"              \"type_id\": null, \n" +
"              \"uri\": null, \n" +
"              \"xids\": null\n" +
"            }, \n" +
"            {\n" +
"              \"copyright\": null, \n" +
"              \"dimensions\": null, \n" +
"              \"duration\": null, \n" +
"              \"extended_attributes\": null, \n" +
"              \"id\": \"GNDPKBD8MRE0E5Q\", \n" +
"              \"rights_holder\": null, \n" +
"              \"status_id\": null, \n" +
"              \"subtype_id\": null, \n" +
"              \"type_id\": null, \n" +
"              \"uri\": null, \n" +
"              \"xids\": null\n" +
"            }\n" +
"          ]\n" +
"        }, \n" +
"        \"ratings\": {\n" +
"          \"rating\": [\n" +
"            {\n" +
"              \"ord\": null, \n" +
"              \"property_subtype_id\": \"RTG_USA_04_04\", \n" +
"              \"property_type_id\": \"RTG_USA_04\", \n" +
"              \"property_value\": null\n" +
"            }\n" +
"          ]\n" +
"        }, \n" +
"        \"season\": null, \n" +
"        \"series\": null, \n" +
"        \"status_id\": \"active\", \n" +
"        \"subtype_id\": \"OTHER_SPECIAL\", \n" +
"        \"titles\": {\n" +
"          \"title\": [\n" +
"            {\n" +
"              \"copyright\": null, \n" +
"              \"extended_attributes\": null, \n" +
"              \"id\": null, \n" +
"              \"length\": 68, \n" +
"              \"rights_holder\": null, \n" +
"              \"status_id\": null, \n" +
"              \"subtype_id\": \"TTL_MAIN\", \n" +
"              \"text\": \"Sugar Ray Robinson: The Bright Lights and Dark Shadows of a Champion\", \n" +
"              \"type_id\": \"TTL_PRIMARY\"\n" +
"            }, \n" +
"            {\n" +
"              \"copyright\": null, \n" +
"              \"extended_attributes\": null, \n" +
"              \"id\": null, \n" +
"              \"length\": 18, \n" +
"              \"rights_holder\": null, \n" +
"              \"status_id\": null, \n" +
"              \"subtype_id\": \"TTL_MAIN\", \n" +
"              \"text\": \"Sugar Ray Robinson\", \n" +
"              \"type_id\": \"TTL_REDUCED\"\n" +
"            }, \n" +
"            {\n" +
"              \"copyright\": null, \n" +
"              \"extended_attributes\": null, \n" +
"              \"id\": null, \n" +
"              \"length\": 12, \n" +
"              \"rights_holder\": null, \n" +
"              \"status_id\": null, \n" +
"              \"subtype_id\": \"TTL_MAIN\", \n" +
"              \"text\": \"Ray Robinson\", \n" +
"              \"type_id\": \"TTL_REDUCED\"\n" +
"            }, \n" +
"            {\n" +
"              \"copyright\": null, \n" +
"              \"extended_attributes\": null, \n" +
"              \"id\": null, \n" +
"              \"length\": 11, \n" +
"              \"rights_holder\": null, \n" +
"              \"status_id\": null, \n" +
"              \"subtype_id\": \"TTL_MAIN\", \n" +
"              \"text\": \"R. Robinson\", \n" +
"              \"type_id\": \"TTL_REDUCED\"\n" +
"            }, \n" +
"            {\n" +
"              \"copyright\": null, \n" +
"              \"extended_attributes\": null, \n" +
"              \"id\": null, \n" +
"              \"length\": 36, \n" +
"              \"rights_holder\": null, \n" +
"              \"status_id\": null, \n" +
"              \"subtype_id\": \"TTL_MAIN\", \n" +
"              \"text\": \"Sugar Ray Robinson: Lights & Shadows\", \n" +
"              \"type_id\": \"TTL_REDUCED\"\n" +
"            }, \n" +
"            {\n" +
"              \"copyright\": null, \n" +
"              \"extended_attributes\": null, \n" +
"              \"id\": null, \n" +
"              \"length\": 50, \n" +
"              \"rights_holder\": null, \n" +
"              \"status_id\": null, \n" +
"              \"subtype_id\": \"TTL_MAIN\", \n" +
"              \"text\": \"Sugar Ray Robinson: Lights & Shadows of a Champion\", \n" +
"              \"type_id\": \"TTL_REDUCED\"\n" +
"            }, \n" +
"            {\n" +
"              \"copyright\": null, \n" +
"              \"extended_attributes\": null, \n" +
"              \"id\": null, \n" +
"              \"length\": 28, \n" +
"              \"rights_holder\": null, \n" +
"              \"status_id\": null, \n" +
"              \"subtype_id\": \"TTL_MAIN\", \n" +
"              \"text\": \"Sugar Ray Robinson: Champion\", \n" +
"              \"type_id\": \"TTL_REDUCED\"\n" +
"            }, \n" +
"            {\n" +
"              \"copyright\": null, \n" +
"              \"extended_attributes\": null, \n" +
"              \"id\": null, \n" +
"              \"length\": 62, \n" +
"              \"rights_holder\": null, \n" +
"              \"status_id\": null, \n" +
"              \"subtype_id\": \"TTL_MAIN\", \n" +
"              \"text\": \"Sugar Ray Robinson: Bright Lights & Dark Shadows of a Champion\", \n" +
"              \"type_id\": \"TTL_REDUCED\"\n" +
"            }, \n" +
"            {\n" +
"              \"copyright\": null, \n" +
"              \"extended_attributes\": null, \n" +
"              \"id\": null, \n" +
"              \"length\": 5, \n" +
"              \"rights_holder\": null, \n" +
"              \"status_id\": null, \n" +
"              \"subtype_id\": \"TTL_MAIN\", \n" +
"              \"text\": \"Sugar\", \n" +
"              \"type_id\": \"TTL_REDUCED\"\n" +
"            }\n" +
"          ]\n" +
"        }, \n" +
"        \"type_id\": \"SHOWS\", \n" +
"        \"uris\": null, \n" +
"        \"warnings\": null, \n" +
"        \"xids\": {\n" +
"          \"xid\": [\n" +
"            {\n" +
"              \"extended_attributes\": null, \n" +
"              \"id\": \"495619\", \n" +
"              \"status_id\": null, \n" +
"              \"subtype_id\": null, \n" +
"              \"type_id\": \"root_id\", \n" +
"              \"vendor_id\": \"TMS\"\n" +
"            }, \n" +
"            {\n" +
"              \"extended_attributes\": null, \n" +
"              \"id\": null, \n" +
"              \"status_id\": null, \n" +
"              \"subtype_id\": null, \n" +
"              \"type_id\": \"parent_tms_id\", \n" +
"              \"vendor_id\": \"TMS\"\n" +
"            }, \n" +
"            {\n" +
"              \"extended_attributes\": null, \n" +
"              \"id\": \"907908\", \n" +
"              \"status_id\": null, \n" +
"              \"subtype_id\": null, \n" +
"              \"type_id\": \"version_mapping_id\", \n" +
"              \"vendor_id\": \"TMS\"\n" +
"            }, \n" +
"            {\n" +
"              \"extended_attributes\": null, \n" +
"              \"id\": \"568277\", \n" +
"              \"status_id\": null, \n" +
"              \"subtype_id\": null, \n" +
"              \"type_id\": \"titleset_id\", \n" +
"              \"vendor_id\": \"TMS\"\n" +
"            }, \n" +
"            {\n" +
"              \"extended_attributes\": null, \n" +
"              \"id\": \"SH002878230000\", \n" +
"              \"status_id\": null, \n" +
"              \"subtype_id\": null, \n" +
"              \"type_id\": \"tms_id\", \n" +
"              \"vendor_id\": \"TMS\"\n" +
"            }\n" +
"          ]\n" +
"        }\n" +
"      }\n" +
"    ]\n" +
"  }, \n" +
"  \"source_contexts\": null, \n" +
"  \"udate\": null, \n" +
"  \"uuser\": null\n" +
"}\n"

@JvmStatic  fun main(args:Array<String>) {
val id = JsonPath.read<String>(json, "$.id")
val ids = JsonPath.parse(json).read<List<*>>("$..program_context[*].id", List<*>::class.java)
println(ids)
}
}
