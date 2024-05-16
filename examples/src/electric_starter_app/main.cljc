(ns electric-starter-app.main
  (:require [hyperfiddle.electric :as e]
            [hyperfiddle.electric-dom2 :as dom]
            [conjurernix.electric-franken :as ui]
            [hashp.core]))

;; Saving this file will automatically recompile and update in your browser

(e/defn Main [ring-request]
  (e/server
    (e/client
      (binding [dom/node js/document.body]
        (dom/div (dom/props {:class "flex flex-col gap-8 p-10"})

          ;; Accordion Examples
          (dom/div (dom/props {:class "flex-1"})
            (dom/props {:class "w-1/2 m-auto"})
            (dom/h1
              (dom/props {:class "mb-4"})
              (dom/text "Accordion Example"))
            (ui/Accordion. {:items [{:title   "Item 1"
                                     :content "Lorem Ipsum"
                                     :open?   true}
                                    {:title   "Item 2"
                                     :content "Lorem Ipsum"}]}))
          (dom/div (dom/props {:class "flex-1"})
            (dom/props {:class "w-1/2 m-auto"})
            (dom/h1
              (dom/props {:class "mb-4"})
              (dom/text "Accordion Example with custom content"))
            (ui/Accordion. {:items [{:title   "Item 1"
                                     :content (e/fn []
                                                (dom/div (dom/props {:class "bg-red-300 p-5"})
                                                  (dom/text "Lorem Ipsum")))
                                     :open    true}
                                    {:title   "Item 2"
                                     :content "Lorem Ipsum"}]}))
          (dom/div (dom/props {:class "flex-1"})
            (dom/props {:class "w-1/2 m-auto"})
            (dom/h1
              (dom/props {:class "mb-4"})
              (dom/text "Accordion Example with Multiple open and Collapsible false"))
            (ui/Accordion. {:multiple    true
                            :collapsible false
                            :items       [{:title   "Item 1"
                                           :content "Lorem Ipsum"
                                           :open?   true}
                                          {:title   "Item 2"
                                           :content "Lorem Ipsum"}]}))

          ;; Alert Examples
          (dom/div (dom/props {:class "flex-1"})
            (dom/props {:class "w-1/2 m-auto"})
            (dom/h1
              (dom/props {:class "mb-4"})
              (dom/text "Alert Example"))
            (ui/Alert. {:body "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod
                                 tempor incididunt ut labore et dolore magna aliqua."}))

          (dom/div (dom/props {:class "flex-1"})
            (dom/props {:class "w-1/2 m-auto"})
            (dom/h1
              (dom/props {:class "mb-4"})
              (dom/text "Alert Example with title, description and close button"))
            (ui/Alert. {:title       "Notice"
                        :description "A description for your alert"
                        :close       true}))

          (dom/div (dom/props {:class "flex-1"})
            (dom/props {:class "w-1/2 m-auto"})
            (dom/h1
              (dom/props {:class "mb-4"})
              (dom/text "Alert Example with danger type"))
            (ui/Alert. {:style :danger
                        :body  "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod
                                 tempor incididunt ut labore et dolore magna aliqua."}))

          (dom/div (dom/props {:class "flex-1"})
            (dom/props {:class "w-1/2 m-auto"})
            (dom/h1
              (dom/props {:class "mb-4"})
              (dom/text "Alert Example with custom body"))
            (ui/Alert. {:body (ui/fragment
                                (ui/AlertClose.)
                                (ui/AlertTitle. "Hello")
                                (ui/AlertDescription. "World"))}))

          ;; Badge Examples
          (dom/div (dom/props {:class "flex-1"})
            (dom/props {:class "w-1/2 m-auto"})
            (dom/h1
              (dom/props {:class "mb-4"})
              (dom/text "Badge Example"))
            (ui/Badge. {:body "1"})
            (ui/Badge. {:style :primary :body "100"})
            (ui/Badge. {:style :secondary :body "100"})
            (ui/Badge. {:style :danger :body "100"}))

          ;; Breadcrumb examples
          (dom/div (dom/props {:class "flex-1"})
            (dom/props {:class "w-1/2 m-auto"})
            (dom/h1
              (dom/props {:class "mb-4"})
              (dom/text "Breadcrumb Example"))
            (ui/Breadcrumb. {:items [{:href "#"
                                      :body "Home"}
                                     {:href "#"
                                      :body "Templates"}
                                     {:disabled true
                                      :body     "Disabled"}
                                     {:body "Franken UI"}]}))

          ;; Button Examples
          (dom/div (dom/props {:class "flex-1"})
            (dom/props {:class "w-1/2 m-auto"})
            (dom/h1
              (dom/props {:class "mb-4"})
              (dom/text "Button Example"))
            (dom/p (dom/props {:class "flex flex-wrap gap-3"})
              (ui/ButtonLink. {:href "#"
                               :body "Link"})
              (ui/Button. {:body     "Button"
                           :on-click (e/fn [_e]
                                       (js/alert "Clicked"))})
              (ui/Button. {:disabled true
                           :body     "Disabled"})))

          (dom/div (dom/props {:class "flex-1"})
            (dom/props {:class "w-1/2 m-auto"})
            (dom/h1
              (dom/props {:class "mb-4"})
              (dom/text "Button Example with different styles"))
            (dom/p (dom/props {:class "flex flex-wrap gap-3"})
              (ui/Button. {:style :primary :body "Click me!"})
              (ui/Button. {:style :secondary :body "Click me!"})
              (ui/Button. {:style :danger :body "Click me!"})
              (ui/Button. {:style :text :body "Click me!"})
              (ui/Button. {:style :link :body "Click me!"})))


          ;; Card Examples

          (dom/div (dom/props {:class "flex-1"})
            (dom/props {:class "w-1/2 m-auto"})
            (dom/h1
              (dom/props {:class "mb-4"})
              (dom/text "Simple Card Example"))
            (dom/p (dom/props {:class "flex flex-wrap gap-3"})
              (ui/Card. {:title "Greetings"
                         :body  "Lorem Ipsum"})))

          (dom/div (dom/props {:class "flex-1"})
            (dom/props {:class "w-1/2 m-auto"})
            (dom/h1
              (dom/props {:class "mb-4"})
              (dom/text "Card Example with header, content and footer"))
            (dom/p (dom/props {:class "flex flex-wrap gap-3"})
              (ui/Card. {:header  (e/fn []
                                    (ui/CardTitle. "This is a title in a header"))
                         :content "Lorem ipsum dolor sit amet, consectetur adipisicing elit."
                         :footer  (e/fn []
                                    (dom/div (dom/props {:class "flex justify-between"})
                                      (ui/Button. {:style :danger
                                                   :body  "Cancel"})
                                      (ui/Button. {:body "Save"})))})))

          ;; CountDown Example

          (dom/div (dom/props {:class "flex-1"})
            (dom/props {:class "w-1/2 m-auto"})
            (dom/h1
              (dom/props {:class "mb-4"})
              (dom/text "Countdown Example"))
            (dom/p (dom/props {:class "flex flex-wrap gap-3"})
              (ui/Countdown. {:date "2024-05-20T07:15:50+00:00"})))

          (dom/div (dom/props {:class "flex-1"})
            (dom/props {:class "w-1/2 m-auto"})
            (dom/h1
              (dom/props {:class "mb-4"})
              (dom/text "Custom Countdown example"))
            (dom/p (dom/props {:class "flex flex-wrap gap-3"})
              (ui/Countdown. {:date "2024-05-20T07:15:50+00:00"
                              :body (e/fn []
                                      (ui/CountdownDays.)
                                      (ui/CountdownSeparator. "*")
                                      (ui/CountdownHours.)
                                      (ui/CountdownSeparator. "*")
                                      (ui/CountdownMinutes.))})))

          ;; Cover Example TODO

          ;; Divider
          (dom/div (dom/props {:class "flex-1"})
            (dom/props {:class "w-1/2 m-auto"})
            (dom/h1
              (dom/props {:class "mb-4"})
              (dom/text "Simple Divider example"))
            (dom/div (dom/props {:class "flex flex-wrap gap-3"})
              (dom/div (dom/props {:class "w-full"})
                (ui/Divider. {:type :icon}))
              (dom/div (dom/props {:class "w-full"})
                (ui/Divider. {:type :small}))
              (dom/div (dom/props {:class "w-full"})
                (ui/Divider. {:type :vertical}))))

          ;; Dotnav
          (dom/div (dom/props {:class "flex-1"})
            (dom/props {:class "w-1/2 m-auto"})
            (dom/h1
              (dom/props {:class "mb-4"})
              (dom/text "Simple Dotnav example"))
            (dom/div (dom/props {:class "flex flex-wrap gap-3"})
              (ui/Dotnav. {:items [{:active true
                                    :body   "Item 1"}
                                   {:body "Item 2"}
                                   {:body "Item 3"}]})))

          (dom/div (dom/props {:class "flex-1"})
            (dom/props {:class "w-1/2 m-auto"})
            (dom/h1
              (dom/props {:class "mb-4"})
              (dom/text "Vertical Dotnav example"))
            (dom/div (dom/props {:class "flex flex-wrap gap-3"})
              (ui/Dotnav. {:vertical true
                           :items    [{:active true
                                       :body   "Item 1"}
                                      {:body "Item 2"}
                                      {:body "Item 3"}]})))

          (dom/div (dom/props {:class "flex-1"})
            (dom/props {:class "w-1/2 m-auto"})
            (dom/h1
              (dom/props {:class "mb-4"})
              (dom/text "Drop example"))
            (dom/div (dom/props {:class "flex flex-wrap gap-3"})
              (ui/Button. {:body "Click to drop!"})
              (ui/Drop. {:mode :click
                         :body (e/fn []
                                 (ui/Card. {:title "Dropped!"
                                            :body  "because you clicked"}))})))

          (dom/div (dom/props {:class "flex-1"})
            (dom/props {:class "w-1/2 m-auto"})
            (dom/h1
              (dom/props {:class "mb-4"})
              (dom/text "Drop example by hover"))
            (dom/div (dom/props {:class "flex flex-wrap gap-3"})
              (ui/Button. {:body
                           (e/fn [] (dom/text "Hover with icon ") (ui/DropParentIcon.))})
              (ui/Drop. {:mode :hover
                         :body (e/fn []
                                 (ui/Card. {:title "Dropped!"
                                            :body  "because you hovered"}))})))

          ;; Dropbar

          (dom/div (dom/props {:class "flex-1"})
            (dom/props {:class "w-1/2 m-auto"})
            (dom/h1
              (dom/props {:class "mb-4"})
              (dom/text "Dropbar example"))
            (dom/div (dom/props {:class "flex flex-wrap gap-3"})
              (ui/Inline.
                (e/fn []
                  (ui/Button. {:body "Click to drop!"})
                  (ui/Dropbar. {:direction :bottom
                                :mode      :click
                                :pos       :top-right
                                :body      (e/fn []
                                             (ui/Card. {:title "Dropbar"
                                                        :body  "Lorem ipsum dolor sit amet, consectetur adipiscing elit,
                                   sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
                                   quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat"}))})))))

          ;; Dropdown Example
          (dom/div (dom/props {:class "flex-1"})
            (dom/props {:class "w-1/2 m-auto"})
            (dom/h1
              (dom/props {:class "mb-4"})
              (dom/text "Dropdown Example"))
            (dom/div (dom/props {:class "flex flex-wrap gap-3"})
              (ui/Inline.
                (e/fn []
                  (dom/props {:class "mr-2"})
                  (ui/Button. {:body "Click to drop!"})
                  (ui/Dropdown. {:body (e/fn []
                                         (dom/props {:class "p-6"})
                                         (dom/text "Lorem ipsum dolor sit amet, consectetur adipiscing elit,
                  sed do eiusmod tempor incididunt ut labore et dolore magna aliqua"))})))))

          (dom/div (dom/props {:class "flex-1"})
            (dom/props {:class "w-1/2 m-auto"})
            (dom/h1
              (dom/props {:class "mb-4"})
              (dom/text "Dropdown Nav Example"))
            (dom/div (dom/props {:class "flex flex-wrap gap-3"})
              (ui/Inline.
                (e/fn []
                  (dom/props {:class "mr-2"})
                  (ui/Button. {:body "Click to drop!"})
                  (ui/Dropdown. {:nav-items [{:active true :body "Active"}
                                             {:body "Item"}
                                             {:header true :body "Header"}
                                             {:body "Item"}
                                             {:body "Item"}
                                             {:divider true}
                                             {:body "Item"}]})))))

          ; Dropnav Example

          (dom/div (dom/props {:class "flex-1"})
            (dom/props {:class "w-1/2 m-auto"})
            (dom/h1
              (dom/props {:class "mb-4"})
              (dom/text "Dropdown Nav Example"))
            (dom/div (dom/props {:class "flex flex-wrap gap-3"})
              (ui/Dropnav. {:subnavs [{:active true :body "Active"}
                                      {:label     "Parent"
                                       :nav-items [{:active true
                                                    :body   "Active"}
                                                   {:body "Item"}
                                                   {:body "Item"}]}
                                      {:label     "Parent"
                                       :nav-items [{:active true
                                                    :body   "Active"}
                                                   {:body "Item"}
                                                   {:body "Item"}]}
                                      {:body "Item"}]})))

          ;; Filter Example

          (dom/div (dom/props {:class "flex-1"})
            (dom/props {:class "w-1/2 m-auto"})
            (dom/h1
              (dom/props {:class "mb-4"})
              (dom/text "Dropdown Nav Example"))
            (dom/div (dom/props {:class "flex flex-wrap gap-3"})
              (ui/Filter. {:selector        ".js-filter"
                           :filter-controls [{:selector ".tag-transparent"
                                              :body     "Transparent"}
                                             {:selector ".tag-primary"
                                              :body     "Primary"}
                                             {:selector ".tag-secondary"
                                              :body     "Secondary"}
                                             {:body "Clear"}]
                           :body            (e/fn []
                                              (dom/ul (dom/props {:class "js-filter grid grid-cols-2 md:grid-cols-3 gap-3 mt-5"})
                                                (dom/li (dom/props {:class "tag-transparent"})
                                                  (dom/div (dom/props {:class "uk-card uk-card-default uk-card-body"})
                                                    (dom/text "Item")))
                                                (dom/li (dom/props {:class "tag-primary"})
                                                  (dom/div (dom/props {:class "uk-card uk-card-primary uk-card-body"})
                                                    (dom/text "Item")))
                                                (dom/li (dom/props {:class "tag-transparent"})
                                                  (dom/div (dom/props {:class "uk-card uk-card-default uk-card-body"})
                                                    (dom/text "Item")))
                                                (dom/li (dom/props {:class "tag-transparent"})
                                                  (dom/div (dom/props {:class "uk-card uk-card-default uk-card-body"})
                                                    (dom/text "Item")))
                                                (dom/li (dom/props {:class "tag-secondary"})
                                                  (dom/div (dom/props {:class "uk-card uk-card-secondary uk-card-body"})
                                                    (dom/text "Item")))
                                                (dom/li (dom/props {:class "tag-secondary"})
                                                  (dom/div (dom/props {:class "uk-card uk-card-secondary uk-card-body"})
                                                    (dom/text "Item")))
                                                (dom/li (dom/props {:class "tag-primary"})
                                                  (dom/div (dom/props {:class "uk-card uk-card-primary uk-card-body"})
                                                    (dom/text "Item")))
                                                (dom/li (dom/props {:class "tag-secondary"})
                                                  (dom/div (dom/props {:class "uk-card uk-card-secondary uk-card-body"})
                                                    (dom/text "Item")))
                                                (dom/li (dom/props {:class "tag-primary"})
                                                  (dom/div (dom/props {:class "uk-card uk-card-primary uk-card-body"})
                                                    (dom/text "Item")))
                                                (dom/li (dom/props {:class "tag-transparent"})
                                                  (dom/div (dom/props {:class "uk-card uk-card-default uk-card-body"})
                                                    (dom/text "Item")))
                                                (dom/li (dom/props {:class "tag-primary"})
                                                  (dom/div (dom/props {:class "uk-card uk-card-primary uk-card-body"})
                                                    (dom/text "Item")))
                                                (dom/li (dom/props {:class "tag-secondary"})
                                                  (dom/div (dom/props {:class "uk-card uk-card-secondary uk-card-body"})
                                                    (dom/text "Item")))))}))))))))
