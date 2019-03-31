(ns dexcom-api2.routes.home
  (:require
    [dexcom-api2.layout :as layout]
    [clojure.java.io :as io]
    [dexcom-api2.middleware :as middleware]
    [ring.util.http-response :as response]
    [clj-http.client :as http]
    [dexcom-api2.config :refer [env]]
    [slingshot.slingshot :refer [try+]]))

(defn home-page [request]
  (layout/render request "home.html" {:docs (-> "docs/docs.md" io/resource slurp)}))

(defn about-page [request]
  (layout/render request "about.html"))

(defn liveness-probe [request]
  (response/ok {:body {:alive true}}))

(defn home-routes []
  [""
   {:middleware [middleware/wrap-csrf
                 middleware/wrap-formats]}
   ["/" {:get home-page}]
   ["/about" {:get about-page}]
   ["/healthz" {:get liveness-probe}]])

