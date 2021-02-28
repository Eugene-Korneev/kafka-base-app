CREATE TABLE weather (
    lng DOUBLE,
    lat DOUBLE,
    avg_tmpr_f DOUBLE,
    avg_tmpr_c DOUBLE,
    wthr_date STRING
)
    STORED AS PARQUET
    LOCATION '/201_hw_dataset/weather';
