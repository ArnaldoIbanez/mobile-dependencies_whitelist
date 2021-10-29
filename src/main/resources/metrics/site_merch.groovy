package metrics
package metrics

import static com.ml.melidata.metrics.parsers.dsl.MetricsDsl.metrics

metrics {
    "home_placement_click"(description: "Clicks on placements of Home") {
        experiment(regex("mkplc/.*sitemerch.*"))

        countsOn {
            condition {
                and(
                    notEquals("path", "/recommendations"),
                    or (
                        and(
                            like("device.platform", "/mobile/.*"),
                            like("platform.fragment.c_id", "/home/exhibitors/elem.*|/home/discovery-.*/elem.*|/home/collection-item.*")
                        ),
                        and(
                            like("device.platform", "/web/.*"),
                            like("platform.fragment.c_id", "/home/exhibitors-carousel/elem.*|/home/discovery-.*/elem.*|/home/collections/item.*")
                        )
                    )
                )
            }
        }
    }
}
