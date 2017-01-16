{
  "users": [
    "juan.lambre@mercadolibre.com"
  ],
  "process_name": "duplicate_tracks_count",
  "cron": "* 07 * * *",
  "extract": {
    "operation": "overwrite",
    "columns": [
      {
        "name": "ds",
        "type": "DATE",
        "format": "yyyy-MM-dd"
      },
      {
        "name": "total",
        "type": "INTEGER"
      },
      {
        "name": "distinct_total",
        "type": "INTEGER"
      },
      {
        "name": "source",
        "type": "UNICODE_STRING"
      }
    ],
    "sql": {
      "script": "duplicate-tracks-count.sql",
      "parameters": [
        {
          "name": "param01",
          "value": "DAY-0",
          "format": "yyyy-MM-dd"
        },
        {
          "name": "param02",
          "value": "DAY-15",
          "format": "yyyy-MM-dd"
        }
      ]
    }
  }
}
