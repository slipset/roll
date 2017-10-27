(ns roll.modules.vpc)

(defn generate
  "If no VPC is specified, we need to create one."
  [{:keys [environment] :as config}]
  (when (not (:vpc-id config))
    {:resource
     {:aws-vpc
      {:main
       :cidr_block "10.0.0.0/16"
       :tags {:Name environment}}}}))


;; must take cidr_block - how does this play with where cidr is used elsehere? where it is
