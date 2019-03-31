(ns user
  (:require
    [dexcom-api2.config :refer [env]]
    [clojure.spec.alpha :as s]
    [expound.alpha :as expound]
    [mount.core :as mount]
    [dexcom-api2.core :refer [start-app]]))

(alter-var-root #'s/*explain-out* (constantly expound/printer))

(defn start []
  (mount/start-without #'dexcom-api2.core/repl-server))

(defn stop []
  (mount/stop-except #'dexcom-api2.core/repl-server))

(defn restart []
  (stop)
  (start))


