(ns electric-starter-app.main
  (:require [hyperfiddle.electric :as e]
            [hyperfiddle.electric-dom2 :as dom]
            [conjurernix.electric-franken.api :as ui]
            [hashp.core]))

;; Saving this file will automatically recompile and update in your browser

(defmacro ExamplesWrapper [title & body]
  `(dom/div (dom/props {:class "flex-1"})
     (dom/props {:class "w-1/2 m-auto"})
     (dom/h1
       (dom/props {:class "mb-4"})
       (dom/text ~title))
     ~@body))

(e/defn Main [ring-request]
  (e/client
    (binding [dom/node js/document.body]
      (dom/div (dom/props {:class "flex flex-col gap-8 p-10"})
        #_(ExamplesWrapper "Accordion Example"
            (ui/Accordion
              (ui/AccordionItem
                (ui/open-accordion-item)
                (ui/AccordionTitle
                  (dom/text "Item 1")
                  (ui/AccordionIcon))
                (ui/AccordionContent
                  (dom/text "Lorem Ipsum")))
              (ui/AccordionItem
                (ui/AccordionTitle
                  (dom/text "Item 1")
                  (ui/AccordionIcon))
                (ui/AccordionContent
                  (dom/text "Lorem Ipsum")))))

        #_(ExamplesWrapper "Accordion Example with Multiple open and Collapsible false"
            (ui/Accordion
              (ui/accordion-opts {:multiple true :collapsible false})
              (ui/AccordionItem
                (ui/open-accordion-item)
                (ui/AccordionTitle
                  (dom/text "Item 1")
                  (ui/AccordionIcon))
                (ui/AccordionContent
                  (dom/text "Lorem Ipsum")))
              (ui/AccordionItem
                (ui/AccordionTitle
                  (dom/text "Item 1")
                  (ui/AccordionIcon))
                (ui/AccordionContent
                  (dom/text "Lorem Ipsum")))))

        #_(ExamplesWrapper "Alert Example"
            (ui/Alert
              (dom/text "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod
                       tempor incididunt ut labore et dolore magna aliqua.")))

        #_(ExamplesWrapper "Alert Example with title description and close icon"
            (ui/Alert
              (ui/AlertClose)
              (ui/AlertTitle
                (dom/text "Notice"))
              (ui/AlertDescription
                (dom/text "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod
                       tempor incididunt ut labore et dolore magna aliqua."))))

        #_(ExamplesWrapper "Alert Example with danger type"
            (ui/Alert
              (ui/alert-danger)
              (ui/AlertClose)
              (ui/AlertTitle
                (dom/text "Notice"))
              (ui/AlertDescription
                (dom/text "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod
                       tempor incididunt ut labore et dolore magna aliqua."))))

        #_(ExamplesWrapper "Badge Example"
            (ui/Badge (dom/text "1"))
            (ui/Badge (dom/text "100")
              (ui/badge-primary))
            (ui/Badge (dom/text "100")
              (ui/badge-secondary))
            (ui/Badge (dom/text "100")
              (ui/badge-danger)))

        #_(ExamplesWrapper "Breadcrumb Example"
            (dom/nav
              (ui/Breadcrumb
                (ui/BreadcrumbItem
                  (dom/a
                    (dom/props {:href "#"})
                    (dom/text "Home")))
                (ui/BreadcrumbItem
                  (dom/a
                    (dom/props {:href "#"})
                    (dom/text "Templates")))
                (ui/BreadcrumbItem
                  (ui/disabled)
                  (dom/a
                    (dom/props {:href "#"})
                    (dom/text "Disabled")))
                (ui/BreadcrumbItem
                  (dom/a
                    (dom/props {:href ""})
                    (dom/text "Franken UI"))))))

        #_(ExamplesWrapper "Button Examples"
            (ui/ButtonLink
              (dom/props {:href "#"})
              (dom/text "Link"))
            (ui/Button
              (dom/text "Button"))
            (ui/Button
              (dom/props {:disabled "true"})
              (dom/text "Disabled"))
            (ui/Button
              (ui/button-ghost)
              (dom/text "ghost"))
            (ui/Button
              (ui/button-danger)
              (dom/text "Danger")))

        #_(ExamplesWrapper "Simple Card Example"
            (ui/Card
              (ui/card-body)
              (ui/CardTitle (dom/text "Greetings"))
              (dom/text "Lorem Ipsum")))

        #_(ExamplesWrapper "Card Example with header, content and footer"
            (ui/Card
              (ui/CardHeader
                (ui/CardTitle (dom/text "This is a title in a header")))
              (ui/CardBody
                (dom/text "Lorem ipsum dolor sit amet, consectetur adipisicing elit."))
              (ui/CardFooter
                (dom/div (dom/props {:class "flex justify-between"})
                  (ui/Button
                    (ui/button-danger)
                    (dom/text "Cancel"))
                  (ui/Button
                    (dom/text "Save"))))))

        ; TODO: Check why separator doesn't render properly (works on fn based api)
        #_(ExamplesWrapper "Countdown Example"
            (ui/Countdown
              (ui/countdown-date "2024-05-20T07:15:50+00:00")
              (ui/CountdownDays)
              (ui/CountdownSeparator
                (dom/text ":"))
              (ui/CountdownHours)
              (ui/CountdownSeparator
                (dom/text ":"))
              (ui/CountdownMinutes)
              (ui/CountdownSeparator
                (dom/text ":"))
              (ui/CountdownSeconds)))

        #_(ExamplesWrapper "Divider Example"
            (ui/IconDivider)
            (ui/SmallDivider
              (dom/props {:class "h-[2px]"}))
            (ui/VerticalDivider))

        #_(ExamplesWrapper "Dotnav Example"
            (ui/DotNav
              (ui/NavItem
                (ui/active)
                (dom/a (dom/props {:href "#"})
                  (dom/text "Item 1")))

              (ui/NavItem
                (dom/a (dom/props {:href "#"})
                  (dom/text "Item 2")))

              (ui/NavItem
                (dom/a (dom/props {:href "#"})
                  (dom/text "Item 3")))))

        #_(ExamplesWrapper "Vertical Dotnav Example"
            (ui/DotNav
              (ui/dotnav-vertical)
              (ui/NavItem
                (ui/active)
                (dom/a (dom/props {:href "#"})
                  (dom/text "Item 1")))

              (ui/NavItem
                (dom/a (dom/props {:href "#"})
                  (dom/text "Item 2")))

              (ui/NavItem
                (dom/a (dom/props {:href "#"})
                  (dom/text "Item 3")))))

        #_(ExamplesWrapper "Drop Example"
            (ui/Inline
              (ui/Button (dom/text "Click to drop"))
              (ui/Drop
                (ui/drop-mode :click)
                (ui/Card
                  (ui/card-body)
                  (ui/CardTitle (dom/text "Dropped!"))
                  (dom/text "because you clicked.")))))


        #_(ExamplesWrapper "Drop Example by hover"
            (ui/Inline
              (ui/Button (dom/text "Click to drop"))
              (ui/Drop
                (ui/drop-mode :hover)
                (ui/Card
                  (ui/card-body)
                  (ui/CardTitle (dom/text "Dropped!"))
                  (dom/text "because you hovered.")))))

        #_(ExamplesWrapper "Dropbar Example"
            (ui/Inline
              (ui/Button (dom/text "Click to drop!"))
              (ui/Dropbar
                (ui/dropbar-direction :top)
                (ui/drop-mode :click)
                (ui/drop-pos :top-right)
                (ui/Card
                  (ui/card-body)
                  (ui/CardTitle (dom/text "Dropped!"))
                  (dom/text "because you clicked.")))))

        #_(ExamplesWrapper "Stretched Dropbar Example"
            (ui/Inline
              (ui/Button (dom/text "Click to drop!"))
              (ui/Dropbar
                (ui/dropbar-direction :top)
                (ui/drop-mode :click)
                (ui/drop-pos :top-right)
                (ui/drop-stretch :x)
                (ui/Card
                  (ui/card-body)
                  (ui/CardTitle (dom/text "Dropped!"))
                  (dom/text "because you clicked.")))))

        #_(ExamplesWrapper "Dropdown Example"
            (ui/Inline
              (dom/props {:class "mr-2"})
              (ui/Button (dom/text "Click to drop!"))
              (ui/Dropdown
                (dom/p
                  (dom/props {:class "p-6"})
                  (dom/text "Lorem ipsum dolor sit amet, consectetur adipiscing elit,
                  sed do eiusmod tempor incididunt ut labore et dolore magna aliqua")))))

        #_(ExamplesWrapper "Dropdown Nav Example"
            (ui/Inline
              (dom/props {:class "mr-2"})
              (ui/Button (dom/text "Navigate"))
              (ui/Dropdown
                (ui/DropdownNav
                  (ui/NavItem
                    (ui/active)
                    (dom/a (dom/props {:href "#"})
                      (dom/text "Item 1")))

                  (ui/NavItem
                    (dom/a (dom/props {:href "#"})
                      (dom/text "Item 2")))

                  (ui/NavItem
                    (dom/a (dom/props {:href "#"})
                      (dom/text "Item 3")))))))

        (ExamplesWrapper "Dropnav Example"
          (ui/Dropnav
            (ui/Subnav
              (ui/NavItem
                (ui/active)
                (dom/a (dom/props {:href "#"})
                  (dom/text "Active")))

              (ui/NavItem
                (dom/a (dom/props {:href ""})
                  (dom/text "Parent")
                  (ui/DropParentIcon
                    (dom/props {:class "ml-2"})))
                (ui/Dropdown
                  (ui/DropdownNav
                    (ui/NavItem
                      (ui/active)
                      (dom/a (dom/props {:href "#"})
                        (dom/text "Item 1")))

                    (ui/NavItem
                      (dom/a (dom/props {:href "#"})
                        (dom/text "Item 2")))

                    (ui/NavItem
                      (dom/a (dom/props {:href "#"})
                        (dom/text "Item 3"))))))

              (ui/NavItem
                (dom/a (dom/props {:href ""})
                  (dom/text "Parent")
                  (ui/DropParentIcon
                    (dom/props {:class "ml-2"})))
                (ui/Dropdown
                  (ui/DropdownNav
                    (ui/NavItem
                      (ui/active)
                      (dom/a (dom/props {:href "#"})
                        (dom/text "Item 1")))

                    (ui/NavItem
                      (dom/a (dom/props {:href "#"})
                        (dom/text "Item 2")))

                    (ui/NavItem
                      (dom/a (dom/props {:href "#"})
                        (dom/text "Item 3"))))))

              (ui/NavItem
                (dom/a (dom/props {:href "#"})
                  (dom/text "Item"))))))

        (ExamplesWrapper "Filters Example"
          (ui/Filter ".js-filter"
            (ui/Subnav
              (ui/FilterControl ".tag-transparent"
                (dom/a (dom/props {:href "#"})
                  (dom/text "Transparent")))
              (ui/FilterControl ".tag-primary"
                (dom/a (dom/props {:href "#"})
                  (dom/text "Primary")))
              (ui/FilterControl ".tag-secondary"
                (dom/a (dom/props {:href "#"})
                  (dom/text "Secondary")))
              (ui/FilterControl ""
                (dom/a (dom/props {:href "#"})
                  (dom/text "None"))))

            (dom/ul (dom/props {:class "js-filter grid grid-cols-2 md:grid-cols-3 gap-3 mt-5"})
              (dom/li (dom/props {:class "tag-primary"})
                (ui/Card
                  (ui/card-primary)
                  (ui/card-body)
                  (dom/text "Item")))
              (dom/li (dom/props {:class "tag-transparent"})
                (ui/Card
                  (ui/card-body)
                  (dom/text "Item")))
              (dom/li (dom/props {:class "tag-secondary"})
                (ui/Card
                  (ui/card-secondary)
                  (ui/card-body)
                  (dom/text "Item")))
              (dom/li (dom/props {:class "tag-primary"})
                (ui/Card
                  (ui/card-primary)
                  (ui/card-body)
                  (dom/text "Item")))
              (dom/li (dom/props {:class "tag-secondary"})
                (ui/Card
                  (ui/card-secondary)
                  (ui/card-body)
                  (dom/text "Item")))
              (dom/li (dom/props {:class "tag-transparent"})
                (ui/Card
                  (ui/card-body)
                  (dom/text "Item")))
              (dom/li (dom/props {:class "tag-transparent"})
                (ui/Card
                  (ui/card-body)
                  (dom/text "Item")))
              (dom/li (dom/props {:class "tag-secondary"})
                (ui/Card
                  (ui/card-secondary)
                  (ui/card-body)
                  (dom/text "Item")))
              (dom/li (dom/props {:class "tag-primary"})
                (ui/Card
                  (ui/card-primary)
                  (ui/card-body)
                  (dom/text "Item")))
              (dom/li (dom/props {:class "tag-secondary"})
                (ui/Card
                  (ui/card-secondary)
                  (ui/card-body)
                  (dom/text "Item")))
              (dom/li (dom/props {:class "tag-transparent"})
                (ui/Card
                  (ui/card-body)
                  (dom/text "Item")))
              (dom/li (dom/props {:class "tag-primary"})
                (ui/Card
                  (ui/card-primary)
                  (ui/card-body)
                  (dom/text "Item"))))))

        (ExamplesWrapper "Form Example"
          (dom/form
            (ui/Fieldset
              (dom/props {:class "flex flex-col gap-3"})
              (ui/Legend (dom/text "Legend"))
              (ui/Input (dom/props {:placeholder "Input"}))

              (ui/Select
                (ui/Option (dom/text "Option 1"))
                (ui/Option (dom/text "Option 2")))

              (dom/div (dom/props {:class "flex gap-3"})
                (ui/Label
                  (ui/Radio)
                  (dom/text "A"))
                (ui/Label
                  (ui/Radio)
                  (dom/text "B")))

              )))

        ))))