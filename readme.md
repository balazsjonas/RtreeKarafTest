```shell script
karaf clean
feature:install scr
install -s mvn:com.github.davidmoten/rtree/0.8.8-SNAPSHOT
install -s mvn:bjonas/RtreeKarafTest/1.0-SNAPSHOT
list
```

Expected result look like this:
```shell script
START LEVEL 100 , List Threshold: 50
ID │ State     │ Lvl │ Version        │ Name
───┼───────────┼─────┼────────────────┼────────────────────────────────────────
22 │ Active    │  80 │ 4.2.8          │ Apache Karaf :: OSGi Services :: Event
44 │ Active    │  80 │ 0.8.8.SNAPSHOT │ rtree
45 │ Installed │  80 │ 1.0.0.SNAPSHOT │ RtreeKarafTest

```