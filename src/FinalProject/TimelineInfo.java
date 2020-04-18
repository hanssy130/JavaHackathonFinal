package FinalProject;

/**
 * Holds the information of Taiwan's decisions regarding COVID-19.
 *
 * @author Justin
 * @version 2020
 */
public class TimelineInfo {

    /**
     * Holds the description of actions regarding Resource Allocation.
     * @return an array of Strings.
     */
    public static String[] resourceAllocation() {
        return new String[]{"The Taiwanese government allocates masks to retailers and sets price"
                + " limit of 50 masks at NT$300 (USD $10). The Ministry of Economic Affairs lists daily"
                + " local mask manufacturing capability at 2.44million units which surpasses the local demand of"
                + " 1.3 million per day.",
                "On this day, 4 million masks released daily from local manufacturers. Only 1-3 masks"
                        + " are allowed per purchase at convenience stores, local pharmacies, and "
                        + "medical supply stores. Mask prices are currently fixed at NT$8 apiece (USD $0.27)."
                        + " Taiwan’s High Prosecutors Office starts a nationwide campaign to stop "
                        + "profiteering by raising prices on disease prevention products; penalty"
                        + " is 1-7 years in jail and a fine up to NT$5 million (USD $167,000)."
                        + " 4 million surgical masks produced per day with 1.4 million allotted to hospitals"
                        + " and medical workers with remaining 2.6 million for consumer sales.",
                "Government facilities (dorms or spare military camps) used for quarantine."
                        + " Soldiers sent to mask factories to aid production. 60 additional surgical"
                        + " mask machines being installed with 10% of capacity reserved for children."
                        + " Each machine can manufacture 100,000 surgical masks per day. Normally,"
                        + " 60 production lines requires 4-6 months to activate but all will be ready in one month."
                        + " The daily output will be boosted to 10 million masks a day.",
                "New name-based rationing system announced for purchase of face masks."
                        + " Engineers with the Digital Minister develop an app for the public"
                        + " to see pharmacies’ mask stocks. 500,000 children’s masks distributed"
                        + " to private kindergartens for free. Lastly, Taipei punishes claw machine"
                        + " operators who sell masks and disinfectants. ",
                "Government invested NT$200M (USD $6.66 million) to purchase equipment "
                        + " and add production lines. 1,800+ Army Reserve troops have"
                        + "aided in mask production across 28 manufacturers. Daily "
                        + "testing capacity for COVID-19 is approximately 1,300 samples."
                        + " Daily mask output is 5 million masks; sellers now allotted 400 masks a day."};
    }

    /**
     * Holds the description of actions regarding Border Control, Travel, & Finding Cases Timeline.
     * @return an array of Strings.
     */
    public static String[] borderControlStage() {
        return new String[] {"Taiwan starts inspecting passengers for coronavirus.",
                "Taiwans sets Level 2 and Level 3 travel alerts to anyone coming/going to China",
                "Taiwan suspends all tours to China",
                "Electronic monitoring of quarantined individuals via government-issued cellphones",
                "Taiwan fines a couple for NT$300,000 for breaking 14-day quarantine rule."};
    }

    /**
     * Holds the description of actions regarding Communication.
     * @return an array of Strings.
     */
    public static String[] communicationsStage() {
        return new String[] {"Taiwan enforces a new policy that people who spread fake news on epidemic"
                + " can be fined up to NT$3 million (USD $100,000)",
                "Government extended school winter break from Feb 15 to Feb 25",
                "Public servants given 14-days of unpaid leave to care for children"
                + " under 12 if reason is due to coronavirus between Feb 11-24.",
                "Criminal Investigation Bureau questioned suspects on spreading a rumor of a toilet"
                + " paper shortage due to face mask production, sparking a toilet paper panic.",
                "NT$60 billion (USD $2 billion) allocated for businesses affected by the epidemic.",
                "Taiwan announces that they'll disinfect public spaces around schools and school "
                + "areas open to the public during winter break. The Ministry of Education announced"
                + " student absences due to fever or respiratory symptoms will not count on students’"
                + " attendance records."
        };
    }

    /**
     * Holds the dates of the resource allocation events.
     * @return an array of Strings.
     */
    public static String[] resourceAllocationDates() {
        return new String[] {"December 31", "January 20", "January 25", "January 29", "February 7"};
    }

    /**
     * Holds the dates of the border control events.
     * @return an array of Strings.
     */
    public static String[] borderControlDates() {
        return new String[] {"January 22", "January 30", "February 2", "February 3", "February 17"};
    }

    /**
     * Holds the dates of the communication events.
     * @return an array of Strings.
     */
    public static String[] communicationDates() {
        return new String[] {"January 22", "February 2", "February 5", "February 11", "February 13"};
    }
}
