(ns conjurernix.electric-franken
  "Traditional component library API with style common in what you find in JS frameworks"
  (:require [hyperfiddle.electric :as e]
            [hyperfiddle.electric-dom2 :as dom]
            [hashp.core]))

;; Data based API
(defmacro fragment [& body]
  `(e/fn [] ~@body))

(e/defn TextOrFragment [v]
  (e/client
    (cond
      (string? v) (dom/text v)
      (fn? v) (v.)
      :else v)))

(e/defn AccordionTitle [title]
  (e/client
    (dom/a (dom/props {:class "uk-accordion-title"
                       :href  true})
      (dom/span (TextOrFragment. title))
      (dom/span (dom/props {:class   "uk-accordion-icon"
                            :uk-icon "icon: chevron-down; ratio: 0.8"})))))

(e/defn AccordionContent [content]
  (e/client
    (dom/div (dom/props {:class "uk-accordion-content"})
      (TextOrFragment. content))))

(e/defn AccordionItem [{:keys [title content open on-show on-hide]}]
  (e/client
    (dom/li
      (when on-show
        (dom/on "show" on-show))
      (when on-hide
        (dom/on "hide" on-hide))
      (dom/props
        ; TODO: Abstract this pattern
        (cond-> {}
          (true? open) (assoc :class "uk-open")))
      (AccordionTitle. title)
      (AccordionContent. content))))

; TODO: Finish porting options and event hooks for Accordion
(e/defn Accordion [{:keys [collapsible multiple items]}]
  (e/client

    (dom/ul (dom/props {"uk-accordion" (cond-> ""
                                         (boolean? collapsible) (str "collapsible: " collapsible ";")
                                         (boolean? multiple) (str "multiple: " multiple ""))
                        :class         "uk-accordion"})
      (e/for [item items]
        (AccordionItem. item)))))

(e/defn AlertTitle [content]
  (e/client
    (dom/div (dom/props {:class "uk-alert-title"})
      (TextOrFragment. content))))

(e/defn AlertDescription [content]
  (e/client
    (dom/div (dom/props {:class "uk-alert-description"})
      (TextOrFragment. content))))

(e/defn AlertClose []
  (e/client
    (dom/a (dom/props {:href     true
                       :uk-close true
                       :class    "uk-alert-close"}))))

(e/defn Alert [{:keys [style close title description body]
                :or   {style :default}}]
  (e/client
    (let [style-class (case style
                        :default "uk-alert-default"
                        :primary "uk-alert-primary"
                        :success "uk-alert-success"
                        :warning "uk-alert-warning"
                        :danger "uk-alert-danger")]
      (dom/div (dom/props {:uk-alert true
                           :class    (str "uk-alert " style-class)})
        (if body
          (TextOrFragment. body)
          (do
            (when (true? close)
              (AlertClose.))
            (when title
              (AlertTitle. title))
            (when description
              (AlertDescription. description))))))))

(e/defn Badge [{:keys [style body]}]
  (e/client
    (let [style-class (case style
                        :primary "uk-badge-primary"
                        :secondary "uk-badge-secondary"
                        :danger "uk-badge-danger"
                        "")]
      (dom/span (dom/props {:class (str "uk-badge " style-class)})
        (TextOrFragment. body)))))

(e/defn BreadcrumbItem [{:keys [href disabled body]}]
  (e/client
    (dom/li (dom/props {:class (cond-> ""
                                 (true? disabled) (str "uk-disabled "))})
      (dom/a (dom/props (cond-> {}
                          (some? href) (assoc :href href)))
        (TextOrFragment. body)))))

(e/defn Breadcrumb [{:keys [items body]}]
  (e/client
    (dom/nav (dom/props {:aria-label "Breadcrumb"})
      (dom/ul (dom/props {:class "uk-breadcrumb"})
        (if body
          (body.)
          (e/for [item items]
            (BreadcrumbItem. item)))))))

(defn button-style->class [style]
  (case style
    :default "uk-button-default"
    :ghost "uk-button-ghost"
    :primary "uk-button-primary"
    :secondary "uk-button-secondary"
    :danger "uk-button-danger"
    :text "uk-button-text"
    :link "uk-button-link"))

(e/defn ButtonLink [{:keys [href disabled style body]
                     :or   {style :default}}]
  (e/client
    (let [style-class (button-style->class style)]
      (dom/a (dom/props (cond-> {:class (str "uk-button " style-class)}
                          (some? href) (assoc :href href)
                          (true? disabled) (assoc :disabled true)))
        (TextOrFragment. body)))))

(e/defn Button [{:keys [type disabled on-click style body]
                 :or   {style :default
                        type  "button"}}]
  (e/client
    (let [style-class (button-style->class style)]
      (dom/button (dom/props (cond-> {:class (str "uk-button " style-class)
                                      :type  "button"}
                               (true? disabled) (assoc :disabled true)))
        (when on-click
          (dom/on "click" on-click))
        (TextOrFragment. body)))))

(defn card-style->class [style]
  (case style
    :default "uk-card-default"
    :primary "uk-card-primary"
    :secondary "uk-card-secondary"
    :danger "uk-card-danger"))

(e/defn CardFooter [body]
  (e/client
    (dom/div (dom/props {:class "uk-card-footer"})
      (TextOrFragment. body))))

(e/defn CardBody [body]
  (e/client
    (dom/div (dom/props {:class "uk-card-body"})
      (TextOrFragment. body))))

(e/defn CardTitle [body]
  (e/client
    (dom/h3 (dom/props {:class "uk-card-title"})
      (TextOrFragment. body))))

(e/defn CardHeader [body]
  (e/client
    (dom/div (dom/props {:class "uk-card-header"})
      (TextOrFragment. body))))

(e/defn Card [{:keys [style header content footer title body]
               :or   {style :default}}]
  (e/client
    (let [style-class (card-style->class style)]
      (dom/div (dom/props {:class (cond-> (str "uk-card " style-class)
                                    (some? body) (str " uk-card-body"))})
        (if (some? body)
          (do
            (when title
              (CardTitle. title))
            (TextOrFragment. body))
          (do
            (when header
              (CardHeader. header))
            (when content
              (CardBody. content))
            (when footer
              (CardFooter. footer))))))))

(e/defn CountdownSeconds []
  (e/client
    (dom/span (dom/props {:class "uk-countdown-number uk-countdown-seconds"}))))

(e/defn CountdownMinutes []
  (e/client
    (dom/span (dom/props {:class "uk-countdown-number uk-countdown-minutes"}))))

(e/defn CountdownHours []
  (e/client
    (dom/span (dom/props {:class "uk-countdown-number uk-countdown-hours"}))))

(e/defn CountdownDays []
  (e/client
    (dom/span (dom/props {:class "uk-countdown-number uk-countdown-days"}))))

(e/defn CountdownSeparator [separator]
  (e/client
    (dom/span (dom/props {:class "uk-countdown-separator"})
      (TextOrFragment. separator))))

; TODO: Handle formatting of date
(e/defn Countdown [{:keys [date separator days hours minutes seconds body]
                    :or   {days      true
                           hours     true
                           minutes   true
                           seconds   true
                           separator ":"}}]
  (e/client
    (dom/div (dom/props {:uk-countdown (str "date: " date)})
      (if body
        (TextOrFragment. body)
        (let [order (cond-> []
                      days (conj :days)
                      hours (conj :hours)
                      minutes (conj :minutes)
                      seconds (conj :seconds)
                      separator (->> (interpose :separator)))]
          (e/for [item order]
            (case item
              :days (CountdownDays.)
              :hours (CountdownHours.)
              :minutes (CountdownMinutes.)
              :seconds (CountdownSeconds.)
              :separator (CountdownSeparator. separator))))))))

(e/defn CoverVideo [{:keys [src autoplay loop muted playsinline]}]
  (e/client
    (dom/video (dom/props (cond-> {:uk-cover true
                                   :src      src}
                            (true? autoplay) (assoc :autoplay true)
                            (true? loop) (assoc :loop true)
                            (true? muted) (assoc :muted true)
                            (true? playsinline) (assoc :playsinline true))))))

(e/defn CoverImg [{:keys [src alt]}]
  (e/client
    (dom/img (dom/props {:uk-cover true
                         :src      src
                         :alt      (or alt "")}))))

(e/defn Cover [{:keys [img video body]}]
  (e/client
    (dom/div (dom/props {:class "uk-cover-container"})
      (cond
        img (CoverImg. img)
        video (CoverVideo. video)
        body (TextOrFragment. body)))))

(e/defn Divider [{:keys [type]
                  :or   {type :default}}]
  (e/client
    (dom/hr (dom/props {:class (case type
                                 :icon "uk-divider-icon"
                                 :small "uk-divider-small h-[2px] "
                                 :vertical "uk-divider-vertical")}))))

(e/defn NavItemDivider [_]
  (e/client (dom/li (dom/props {:class "uk-nav-divider"}))))

(e/defn NavItemHeader [{:keys [href body]
                        :or   {href "#"}}]
  (e/client
    (dom/li (dom/props {:class "uk-nav-header"})
      (TextOrFragment. body))))

(e/defn NavItem [{:keys [active href body header divider]
                  :or   {href "#"}
                  :as   opts}]
  (e/client
    (cond
      (true? header) (NavItemHeader. opts)
      (true? divider) (NavItemDivider. opts)
      :else (dom/li (dom/props {:class (if (true? active) "uk-active" "")})
              (dom/a
                (dom/props {:href href})
                (TextOrFragment. body))))))

(e/defn Dotnav [{:keys [vertical items]}]
  (e/client
    (dom/ul (dom/props {:class (cond-> "uk-dotnav"
                                 (true? vertical) (str " uk-dotnav-vertical"))})
      (e/for [item items]
        (NavItem. item)))))

; TODO Handle all the uk-drop options
(defn uk-drop-props [{:keys [mode pos stretch]}]
  (let [mode (when mode
               (case mode
                 :hover-click "click,hover"
                 :click "click"
                 :hover "hover"))
        pos (when pos
              (case pos
                :top-left "top-left"
                :top-center "top-center"
                :top-right "top-right"
                :bottom-left "bottom-left"
                :bottom-center "bottom-center"
                :bottom-right "bottom-right"
                :left-top "left-top"
                :left-center "left-center"
                :left-bottom "left-bottom"
                :right-top "right-top"
                :right-center "right-center"
                :right-bottom "right-bottom"))
        stretch (when stretch
                  (case stretch
                    true "true"
                    :x "x"
                    :y "y"))]
    (cond-> ""
      mode (str "mode: " mode ";")
      pos (str "pos: " pos ";")
      stretch (str "stretch: " stretch ";"))))

(e/defn DropParentIcon []
  (e/client
    (dom/span (dom/props {:uk-drop-parent-icon ""
                          :class               "ml-2"}))))


(e/defn Drop [{:keys [body] :as args}]
  (e/client
    (dom/div (dom/props {:uk-drop (uk-drop-props args)})
      (TextOrFragment. body))))

(e/defn Dropbar [{:keys [direction body]
                  :or   {direction :bottom}
                  :as   args}]
  (e/client
    (let [direction-class (case direction
                            :top "uk-drop-bar-top"
                            :bottom "uk-drop-bar-bottom"
                            :left "uk-drop-bar-left"
                            :right "uk-drop-bar-right")]
      (dom/div (dom/props {:class   (str "uk-dropbar " direction-class)
                           :uk-drop (uk-drop-props args)})
        (TextOrFragment. body)))))

(e/defn Inline [body]
  (e/client
    (dom/div (dom/props {:class "uk-inline"})
      (body.))))

(e/defn Nav [{:keys [items]}]
  (e/client
    (dom/ul (dom/props {:class "uk-nav"})
      (e/for [item items]
        (NavItem. item)))))

(e/defn DropdownNav [items]
  (e/client
    (dom/ul (dom/props {:class "uk-nav uk-dropdown-nav"})
      (e/for [item items]
        (NavItem. item)))))

(e/defn Dropdown [{:keys [body nav-items] :as args}]
  (e/client
    (dom/div (dom/props {:class       "uk-dropdown"
                         :uk-dropdown (uk-drop-props args)})
      (if (seq nav-items)
        (DropdownNav. nav-items)
        (TextOrFragment. body)))))

(e/defn Dropnav [{:keys [subnavs]}]
  (e/client
    (dom/nav (dom/props {:uk-dropnav ""})
      (dom/ul (dom/props {:class "uk-subnav"})
        (e/for [{:keys [label icon nav-items] :as subnav
                 :or   {icon true}} subnavs]
          (if (seq nav-items)
            (dom/li
              (dom/a (dom/props {:href ""})
                (TextOrFragment. label)
                (when icon
                  (dom/text " ")
                  (DropParentIcon.)))
              (Dropdown. {:nav-items nav-items}))
            (NavItem. subnav)))))))


(e/defn FilterControl [{:keys [selector body]}]
  (e/client
    (dom/li (dom/props {:uk-filter-control selector})
      (dom/a (dom/props {:href ""})
        (TextOrFragment. body)))))

(e/defn Filter [{:keys [selector filter-controls body]}]
  (e/client
    (dom/div (dom/props {:uk-filter selector})
      (dom/ul (dom/props {:class "uk-subnav uk-subnav-primary"})
        (e/for [control filter-controls]
          (FilterControl. control)))
      (body.))))

(defn form-style->class [style]
  (case style
    :primary "primary"
    :danger "danger"))

(e/defn FormInput [{:keys [type value]
                    :or   {type "text"}}]
  (e/client
    (dom/input (dom/props {:class "uk-input"}))))

(e/defn FormSelectOption [{:keys [value]}]
  (e/client
    (dom/option (dom/text value))))

(e/defn FormSelect [{:keys [options]}]
  (e/client
    (dom/select (dom/props {:class "uk-select"})
                (e/for [option options]
                  (FormSelectOption. option)))))

(e/defn FormTextarea [{:keys [rows placeholder value]
                       :or   {rows        3
                              placeholder ""}}]
  (e/client
    (dom/textarea (dom/props {:class       "uk-textarea"
                              :value       value
                              :rows        rows
                              :placeholder placeholder}))))

(e/defn FormRadioOption [{:keys [label name checked]}]
  (e/client
    (dom/label
      (dom/input (dom/props (cond-> {:class "uk-radio"
                                     :name  name
                                     :type  "radio"}
                              (true? checked) (assoc :checked ""))))
      (TextOrFragment. label))))

(e/defn FormRadio [{:keys [items body]}]
  (e/client
    (dom/div
      (if (seq items)
        (e/for [item items]
          (FormRadioOption. item))
        (TextOrFragment. body)))))

(e/defn FormCheckboxOption [{:keys [label checked]}]
  (e/client
    (dom/label
      (dom/input (dom/props (cond-> {:class "uk-checkbox"
                                     :type  "checkbox"}
                              (true? checked) (assoc :checked ""))))
      (TextOrFragment. label))))

(e/defn FormCheckbox [{:keys [items body]}]
  (e/client
    (dom/div
      (if (seq items)
        (e/for [item items]
          (FormCheckboxOption. item))
        (TextOrFragment. body)))))

(e/defn FormRange [{:keys [value min max step]
                    :or   {min  ""
                           max  ""
                           step ""}}]
  (e/client
    (dom/input (dom/props {:class "uk-range"
                           :type  "range"
                           :value value
                           :min   min
                           :max   max
                           :step  step}))))

(e/defn FormToggleSwitch [{:keys [checked style]
                           :or   {style :primary}}]
  (e/client
    (let [style-class (form-style->class style)]
      (dom/input (dom/props (cond-> {:class (str "uk-toggle-switch " style-class)}
                              (true? checked) (assoc :checked "")))))))

(e/defn FormLabel [{:keys [for body]}]
  (e/client
    (dom/label (dom/props (cond-> {:class "uk-form-label"}
                            for (assoc :for for)))
      (TextOrFragment. body))))

(e/defn FormTagDelete []
  (e/client
    (dom/span (dom/props {:class    "uk-close"
                          :uk-close ""}))))

(e/defn FormTag [{:keys [body closeable]}]
  (e/client
    (dom/span (dom/props {:class "uk-tag"})
      (TextOrFragment. body)
      (when closeable
        (FormTagDelete.)))))

(e/defn FormTagInput [{:keys [tags]}]
  (e/client
    (dom/div (dom/props {:class "uk-tag-input"})
      (e/for [tag tags]
        (FormTag. tag)))))

(e/defn FormPinInput [{:keys [length disabled separated]}]
  (e/client
    (dom/div (dom/props {:class (cond-> "uk-pin-input"
                                  (true? disabled) (str " uk-disabled")
                                  (true? separated) (str " uk-separated"))})
      (e/for [_ (range length)]
        (dom/input (dom/props {:type "text" :maxlength "1"}))))))

(e/defn FormHelp [{:keys [body]}]
  (e/client
    (dom/div (dom/props {:class "uk-form-help"})
      (TextOrFragment. body))))

(e/defn FormFieldset [body]
  (e/client
    (dom/fieldset (dom/props {:class "uk-fieldset"})
                  (body.))))

(defn form-layout->class [layout]
  (when layout
    (case layout
      :stacked "uk-form-stacked"
      :horizontal "uk-form-horizontal")))

(e/defn FormControl [{:keys [body]}]
  (e/client
    (dom/div (dom/props {:class "uk-form-controls"})
      (body.))))

(e/defn FormIcon [{:keys [href icon]}]
  (e/client
    (if href
      (dom/a (dom/props {:class   "uk-form-icon"
                         :href    href
                         :uk-icon (str "icon: " (name icon))}))
      (dom/span (dom/props {:class   "uk-form-icon"
                            :uk-icon (str "icon: " (name icon))})))))

(e/defn FormCustom [body]
  (e/client (dom/div (dom/props {:class "uk-form-custom"})
              (body.))))

(e/defn Form [{:keys [layout body]}]
  (e/client
    (let [layout-class (form-layout->class layout)]
      (dom/form (dom/props {:class (cond-> ""
                                     layout-class (str layout-class))})
                (body.)))))






