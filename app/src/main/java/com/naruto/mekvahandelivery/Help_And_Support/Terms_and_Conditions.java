package com.naruto.mekvahandelivery.Help_And_Support;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.naruto.mekvahandelivery.R;

import java.util.ArrayList;

public class Terms_and_Conditions extends AppCompatActivity {

    private RecyclerView mrecyclerView;
    private RecyclerView.Adapter madapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms_and__conditions);

        ArrayList<TermsData> list = new ArrayList<>();

        mrecyclerView = findViewById(R.id.termsRecycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mrecyclerView.setLayoutManager(layoutManager);

        madapter = new TermsAdapter(this,list);
        mrecyclerView.setAdapter(madapter);

        list.add(new TermsData("Terms & Conditions",10));
        list.add(new TermsData("This document describes policy of Mekvahan.com (hereafter referred to as \" Mekvahan \") regarding information received by Mekvahan during your visits to our website or App. The amount and type of information received depends on how one uses the site or app. Mekvahan is a website/app which is the property of Udyamat Ma Viramsava Pvt. Ltd. a company registered under the Companies Act, 2013, having its registered office at Aya Nagar Extn., Delhi - 110047.\n",2));

        list.add(new TermsData("What is Mekvahan.com?\n",3 ));

        list.add(new TermsData("Mekvahan.com is a Online Platform / Public forum which is completely into an automotive sector that provides different types of regular services as well as SOS services (On road and roadside assistance), also known as emergency services .",2));

        list.add(new TermsData("\n'Customer'\n",3));

        list.add(new TermsData("Customer is a visitor on Mekvahan.com website or Mekvahan app who is a registered member and has filled up the form on the website, is not a dealer or not a partner of dealer or not an associate of dealer or who has no objection contacting any car/bike dealer for his car/bike servicing.\n",2));

        list.add(new TermsData("'Service Vendor' / 'Car/bike Vendor' / 'Car/bike Service Vendor'\n",3));

        list.add(new TermsData("A workshop, motor vehicle service workshop which deals with motor vehicle servicing, repairing and/or provides motor vehicle servicing related facility.\n",2));

        list.add(new TermsData("'Franchisee', 'Distributor'\n",3));

        list.add(new TermsData("A representative who represents Mekvahan cities all across India. A representative has Distributor agreement with Mekvahan to operate his office using brand and help Mekvahan customers all across India\n",2));

        list.add(new TermsData("Mekvahan.com Objective - Comfort and Choice\n",3));

        list.add(new TermsData("Providing Customers with a platform to help customer members to book services online  and then the service is done by registered motor vehicle service vendors authorised/certified by Mekvahan. Mekvahan.com is using technology available for WEB and Mobile to allow them to send enquiries and get response from motor vehicle service vendors. Mekvahan is working on \"CUSTOMER CHOICE\" to allow customers to choose the best service for their motor vehicle.\n",2));

        list.add(new TermsData("Value Added Products and Services (VAPS)",3));

        list.add(new TermsData("are provided by Mekvahan for the benefit of customers by associating with other companies. These are products supplied by Mekvahan \\\"as it is\\\" as per suppliers/manufacturer's terms and conditions, and Mekvahan acts as a \\\"reseller\\\" \\\"dealer\\\" of that products or services.",2));

        list.add(new TermsData("\n'Leads'\n",3));

        list.add(new TermsData("Lead means \"enquiry\" generated through online/ offline promotion. It is categorised as a \"QualifiedLead”if the name of the customer and its contact information is correct. “Lead\"and \"lead generation\" does not mean customers will use your services, in other words, a \"lead\" can be considered as \"conversion\", but it may not necessarily result in a Customer actually visiting a dealer. \"Leads\" in all agreements with Service vendors/associates/partners under \"lead generation program\" or \"revenue share program\" are \"qualified\" leads.\n",2));

        list.add(new TermsData("NOTE: All terms and conditions are applicable to \"Every page\" on this domain http://www.mekvahan.com even if it is not mentioned on the page, all visitors must consider this as assumption.\n",2));

        list.add(new TermsData("How It Works\n",3));

        list.add(new TermsData("Mekvahan.com asks a customer to opt for any particular service available on our platform and our authorised/certified dealer will service the motor vehicle of the customer . Mekvahan also for its esteemed customers try to contact and list down all best and authorised motor vehicle service vendors, but it is not necessary that all service vendors may be shown in the list before they decide to become \"Registered Motor Vehicle Dealer Member\". Customer may recommend car/bike dealer and Mekvahan.com would try to make them as \"Registered Motor Vehicle Dealer Member\" as per the Mekvahan.com Terms and Conditions.\n",2));

        list.add(new TermsData("Technology\n",3));

        list.add(new TermsData("Mekvahan.com is using \"Standard\" technology (Web and Mobile) available to meet the objective. Mekvahan.com is associated with companies for Web Hosting, Domain, Mobile SMS Server. The Promoter and Promoter Affiliates of the Company are not liable for any problems or technical malfunction of any telephone network or lines, computer online systems, servers or providers, computer equipment, software, technical problems or traffic congestion on the Internet / Mobile network or at any website, or any combination thereof, including any injury or damage to participants or any other person's computer related to or resulting from sending booking enquiry or participation in or downloading any materials from the website.To secure web forms, Mekvahan.com technical team use secure code and caches to prevent hacking or mis-use of web form and update code from time-to-time. In case of receipt of any unwanted mail from Mekvahan domain should be informed with a URL of the page to help us preventing mis-use of forms.\n",2));

        list.add(new TermsData("Insurance\n",3));

        list.add(new TermsData("It is the Customers responsibility to ensure that their vehicles are properly insured at the time they contact Mekvahan.com. Mekvahan shall in no manner be responsible for any deficiency in service that the dealer may provide, and no indemnification of any loss shall be given by Mekvahan.\n",22));

        list.add(new TermsData("Recommendations\n",3));

        list.add(new TermsData("Mekvahan.com may recommend some facility to their customers using automatic selection by the program. Presently it program/software which \" recommends \" based on two criteria 1. \" location \" and 2. \" member \". Location is \"city \" and Member is  \" Service vendors/auto repair shop \" which is registered with the website. The Mekvahan team is also recommending Customers who call offline on the Mekvahan Helpline. The reason for including \"Members\" in the recommendation is to allow \" verified \" workshops to get enquires rather \" unverified \". Members are updated regularly with their contact details and a part of verified directories on the website. With times, Mekvahan will have ratings and feedback from \" real \" customers, the website will update \" software/program \" to recommend customer based on `` rating'' and `` location'' \" and \" members \". Since Online services are \"free\" to send enquiries, so customer needs to decide based on his requirements for car/bike servicing or other repairs.\n",24));

        list.add(new TermsData("Privacy Policy\n",3));

        list.add(new TermsData("Mekvahan.com keeps customer data private on a secure database and allows motor vehicle service vendors to display information which resides on the Mekvahan.com web server. A dealer can edit information using Mekvahan.com functionality.\n",2));

        list.add(new TermsData("Customer's emails and registration information are not sold or provided to anybody and are kept confidential.\n",2));

        list.add(new TermsData("Customer can search for the service and our authorised Service vendors will send them booking enquiries for confirmation. Mekvahan.com plays an important role of an interface between Customer and car/bike Service vendors and keeps a record of communications / details exchange between them for monitoring purposes.\n",2));

        list.add(new TermsData("WEBSITE AND APP TERMS AND CONDITIONS OF USE\n",3));

        list.add(new TermsData("1. ACCEPTANCE OF TERMS\n",3));

        list.add(new TermsData("Mekvahan provides data for customer to search and send enquiry to motor vehicle service vendors and display a collection of online resources, including auto news, ads, quiz & updates (referred to hereafter as \"the Service\") subject to the following terms and conditions (\"Terms\"). By using the Service in any way, you are agreeing to comply with these Terms. In addition, when using particular Mekvahan services, you agree to abide by any applicable posted guidelines for all Mekvahan services, which may change from time to time.\n",2));

        list.add(new TermsData("You should object to any term or condition of these Terms, any guidelines, or any subsequent modifications there to or become dissatisfied with Mekvahan in any way, your only recourse is to immediately discontinue use of Mekvahan. You are, however, encouraged to inform/complain to our customer care team who will do their best to address your concern/s.\n",2));

        list.add(new TermsData("2. MODIFICATIONS TO THIS AGREEMENT\n",3));

        list.add(new TermsData("We reserve the right, at our sole discretion, to change, modify or otherwise alter these terms and conditions at any time. Such modifications shall become effective immediately upon the posting thereof. You must review this agreement on a regular basis to keep yourself apprised of any changes. You can find the most recent version of these Terms at: www.Mekvahan.com\n",2));

        list.add(new TermsData("3. CONTENT\n",3));

        list.add(new TermsData("The content at Mekvahan.com collects information provided and created by motor vehicle Service vendors / advertisers, content partners, software developers, publishers, marketing agents, employees, users, resellers and other third parties. While every attempt has been made to ascertain the authenticity of the content of the Website,Mekvahan has no control over the accuracy of such information on our pages, and material on the Mekvahan.com. Web site may include technical inaccuracies or typographical errors, and we make no guarantees, nor can we be responsible for any such information, including its authenticity, currency, content, quality, copyright compliance or legality, or any resulting loss or damage. All of the data on motor vehicle services, insurance, problems and Promotions including but not limited to, the prices and the availability of any product or service or any feature thereof, is subject to change without notice by the party providing the Product or Promotion. You should use discretion while browsing the Internet.\n",2));

        list.add(new TermsData("Mekvahan.com reserves the right, in its sole discretion and without any obligation, to make improvements to, or correct any error or omissions in any portion of the Site. Where appropriate, we will endeavour to update information listed on the Web site on a timely basis, but shall not be liable for any inaccuracies.\n",2));

        list.add(new TermsData("All rights, title and interest including trademarks and copyrights in respect of the domain name and site content hosted on the Website are reserved with Mekvahan.com. Users are permitted to read, print or download text, data and/or graphics from the site for their personal use only. Unauthorized access, reproduction, redistribution, transmission and/or dealing with any information contained in this site in any other manner, either in whole or in part, are strictly prohibited, failing which strict legal action will be initiated against such users.\n",2));

        list.add(new TermsData("You understand that all postings, motor vehicle dealer data, messages, text, files, images, photos, videos, sounds, or other materials (\"Content\") posted on, transmitted through, or linked from the Service, are the sole responsibility of the person from whom such Content originated. More specifically, you are entirely responsible for all Content that you post, email or otherwise make available via the Service. You understand that Mekvahan does not entirely control, and is not responsible for Content made available through the Service, and that by using the Service, you may be exposed to Content that is offensive, indecent, inaccurate, misleading, or otherwise objectionable. Furthermore, the Mekvahan site and Content available through the Service may contain links to other websites, which are completely independent of Mekvahan. Mekvahan makes no representation or warranty as to the accuracy, completeness or authenticity of the information contained in any such site.\n",2));

        list.add(new TermsData("Mekvahan makes NO representation that any Manufacturer / car/bike bands or any other and its associate in any manner until clearly specify kind of association or agreement with associates directly or indirectly on the directory/web pages.\n",2));

        list.add(new TermsData("Your linking to any other website is at your own risk. You agree that you must evaluate, and bear all risks associated with the use of any Content, that you may not rely on said Content, and that under no circumstances will Mekvahan be liable in any way for any Content or for any loss or damage of any kind incurred as a result of the use of any Content posted, emailed or otherwise made available via the Service. You acknowledge that Mekvahan does not always pre-screen or approve Content (unless specified), but that Mekvahan shall have the right (but not the obligation) in its sole discretion to refuse, delete or move any Content that is available via the Service, for violating the letter or spirit of the Terms or for any other reason.\n",2));

        list.add(new TermsData("Copyright Logos/Material\n",3));

        list.add(new TermsData("Mekvahan.com has an agreement with \"Service Provider\" (authorized service station, Service vendors, outlets, workshops) and promotes their business by displaying their logos/their service logos and other copyrighted material. Copyrighted logos and pictures are displayed by Mekvahan.com by taking permission from \"Service Provider\" with agreement of promoting their business. Mekvahan.com has no direct association or agreement with manufacturer.\n",2));

        list.add(new TermsData("4. THIRD PARTY CONTENT, SITES, AND SERVICES\n",3));

        list.add(new TermsData("The Mekvahan site and Content available through the Service may contain features and functionalities that may link you or provide you with access to third party content which is completely independent of Mekvahan, including web sites and app, directories, servers, networks, systems, information and databases, applications, software, programs, products or services, and the Internet as a whole.\n",2));

        list.add(new TermsData("Your interactions with organizations and/or individuals found on or through the Service, including payment and delivery of goods or services, and any other terms, conditions, warranties or representations associated with such dealings, are solely between you and such organizations and/or individuals.\n",2));

        list.add(new TermsData("You should make whatever investigation you feel necessary or appropriate before proceeding with any online or offline communication/transaction with any of these third parties.\n",2));

        list.add(new TermsData("You agree that Mekvahan shall not be responsible or liable for any loss or damage of any sort incurred as the result of any such dealings. If there is a dispute between participants on this site, or between users and any third party, you understand and agree that Mekvahan is under no obligation to become involved. In the event that you have a dispute with one or more other users, you hereby release Mekvahan, its officers, employees, agents and successors in rights from claims, demands and damages (actual and consequential) of every kind or nature, known or unknown, suspected and unsuspected, disclosed and undisclosed, arising out of or in any way related to such disputes and / or our service.\n",2));

        list.add(new TermsData("4.1. Customer Disputes with workshops/outlets/shops\n",3));

        list.add(new TermsData("Mekvahan.com registers motor vehicle workshops and promotes them. Service vendors (\"motor vehicle workshop\", \"motor vehicle outlet\") which are providing services to customers (routed through Mekvahan website or local call center) shall be considered THIRD PARTY SERVICES. All Service vendors in the directory are \"easy to search\" based on city, area. Mekvahan deals with \"Service vendors\" and offer their services to customers as mediator as \"concept\". It is not necessarily that all are best in services. Mekvahan.com will also display Customers reviews and suggest service centre based on the available data. In absence of reviews of new service center, it shall be the Customers responsibility to talk to the manager directly and get information at their website page available. Mekvahan.com does not take any responsibility for maintenance issues and quality of services but may help customer to resolve issue if possible with mutual agreements between customers and Service vendors. We hope to build a transparent system online with times to allow all customers (visiting Mekvahan.com website) to give fair feedback and reviews. CUSTOMER CAN NOT CLAIM for any dispute with Mekvahan.com for motor vehicle servicing issues and other dealer disputes. Mekvahan.com has policy to remove Dealer's Business Name from the \"recommendation\" list when found customer dissatisfied based on \"Mekvahan criteria of removal or/and Dealer Termination Policy\" from the list. Mekvahan criteria of removal from the list is of unhappy customers or/and NON - RESPONSIVE to customer issues.\n",2));

        list.add(new TermsData("4.2 ALL DISPUTES: ",3));

        list.add(new TermsData("All legal disputes with customers, Service vendors, associates and any third party or any service related shall be in jurisdiction of Delhi, India. All disputes shall be intimated at our address info [at] Mekvahan.com or sent at the registered office. All disputes are to be resolved by arbitration under the Arbitration & Conciliation Act, 1996 (as amended from time to time.)\n",2));

        list.add(new TermsData("5. NOTIFICATION OF CLAIMS OF INFRINGEMENT\n",3));

        list.add(new TermsData("If you believe that your work has been copied in a way that constitutes copyright infringement, or your intellectual property rights have been otherwise violated, please notify us at info [at] mekvahan.com\n",2));

        list.add(new TermsData("6. PRIVACY AND INFORMATION DISCLOSURE\n",3));

        list.add(new TermsData("Mekvahan has established a Privacy Policy to explain to users how their information is collected and used, which is located at the following web address:\n",2));

        list.add(new TermsData("www.mekvahan.com\n",3));

        list.add(new TermsData("Your use of the Mekvahan website or the Service signifies acknowledgement of and agreement to our Privacy Policy. You further acknowledge and agree that Mekvahan may, in its sole discretion, preserve or disclose your Content, as well as your information, such as email addresses, IP addresses, timestamps, and other user information, if required to do so by law or in the good faith or belief that such preservation or disclosure is reasonably necessary to: comply with legal process; enforce these Terms; respond to claims that any Content violates the rights of third-parties; respond to claims that contact information (e.g. phone number, street address) of a third-party has been posted or transmitted without their consent or as a form of harassment; protect the rights, property, or personal safety of Mekvahan, its users or the general public.\n",2));

        list.add(new TermsData("6.1 Google Advertising Cookie and Privacy Policies\n",3));

        list.add(new TermsData("We use third-party advertising companies to serve ads when you visit our website. These companies may use information (not including your name, address, email address, or telephone number) about your visits to this and other websites in order to provide advertisements about goods and services of interest to you. If you would like more information about this practice and to know your choices about not having this information used by these companies, click here\n",2));

        list.add(new TermsData("6.2 Communication Mediums\n",3));

        list.add(new TermsData("You agree to receive promotional, transactional and commercial communications from Mekvahan through email,SMS and voice.\n",2));

        list.add(new TermsData("7. CONDUCT\n",3));

        list.add(new TermsData("You agree not to post, email, or otherwise make available Content:\n",2));

        list.add(new TermsData("That is unlawful, harmful, threatening, abusive, harassing, defamatory, libelous, invasive of another's privacy, or is harmful to minors in any way.\n",2));

        list.add(new TermsData("That is pornographic in nature.\n",2));

        list.add(new TermsData("That harasses, degrades, intimidates or is hateful toward an individual or group of individuals on the basis of religion, gender, sexual orientation, race, ethnicity, age, or disability.\n",2));

        list.add(new TermsData("That impersonates any person or entity, including, but not limited to, a Mekvahan employee, or falsely state or otherwise misrepresent your affiliation with a person or entity (this provision does not apply to messages that are lawful non-deceptive parodies of public figures.).\n",2));

        list.add(new TermsData("That includes personal or identifying information about another person without that person's explicit consent.\n",2));

        list.add(new TermsData("That is false, deceptive, misleading, deceitful, misinformative, or constitutes \"bait and switch\".\n",2));

        list.add(new TermsData("That infringes on any patent, trademark, trade secret, copyright or other proprietary rights of any party, or Content that you do not have a right to make available under any law or under contractual or fiduciary relationships.\n",2));

        list.add(new TermsData("That constitutes or contains \"affiliate marketing,\" \"link referral code,\" \"junk mail,\" \"spam,\" \"chain letters,\" \"pyramid schemes,\" or unsolicited commercial advertisement.\n",2));

        list.add(new TermsData("That constitutes or contains any form of advertising or solicitation if: posted in areas of the Mekvahan sites which are not designated for such purposes; or emailed to Mekvahan users who have not indicated in writing that it is ok to contact them about other services, products or commercial interests.\n",2));

        list.add(new TermsData("That includes links to commercial services or web sites, except as allowed in \"services\".\n",2));

        list.add(new TermsData("That advertises any illegal service or the sale of any items the sale of which is prohibited or restricted by any applicable law, including without limitation items the sale of which is prohibited or regulated by Indian law.\n",2));

        list.add(new TermsData("That contains software viruses or any other computer code, files or programs designed to interrupt, destroy or limit the functionality of any computer software or hardware or telecommunications equipment.\n",2));

        list.add(new TermsData("That disrupts the normal flow of dialogue with an excessive number of messages (flooding attack) to the Service, or that otherwise negatively affects other users' ability to use the Service.\n",2));

        list.add(new TermsData("That employs misleading email addresses, or forged headers or otherwise manipulated identifiers in order to disguise the origin of Content transmitted through the Service.\n",2));

        list.add(new TermsData("Additionally, you agree not to:\n",2));

        list.add(new TermsData("Contact anyone who has asked not to be contacted.\n",2));

        list.add(new TermsData("\"Stalk\" or otherwise harass anyone.\n",2));

        list.add(new TermsData("Collect personal data about other users for commercial or unlawful purposes;\n",2));

        list.add(new TermsData("Use automated means, including spiders, robots, crawlers, data mining tools, or the like to download data from the Service - unless expressly permitted by Mekvahan.\n",2));

        list.add(new TermsData("Post non-local or otherwise irrelevant Content, repeatedly post the same or similar Content or otherwise impose an unreasonable or disproportionately large load on our infrastructure.\n",2));

        list.add(new TermsData("Attempt to gain unauthorized access to Mekvahan's computer systems or engage in any activity that disrupts, diminishes the quality of, interferes with the performance of, or impairs the functionality of, the Service or the Mekvahan website. \n",2));

        list.add(new TermsData("Use any form of automated device or computer program that enables the submission of postings on Mekvahan without each posting being manually entered by the author thereof (an \"automated posting device\"), including without limitation, the use of any such automated posting device to submit postings in bulk, or for automatic submission of postings at regular intervals.\n",2));

        list.add(new TermsData("8. NO SPAM POLICY\n",3));

        list.add(new TermsData("You understand and agree that sending unsolicited email advertisements to Mekvahan email addresses or through Mekvahan computer systems, which is expressly prohibited by these Terms, will use or cause to be used Mekvahan servers. Any unauthorized use of Mekvahan computer systems is a violation of these Terms and certain federal and state laws. Such violations may subject the sender and his or her agents to civil and criminal penalties.\n",2));

        list.add(new TermsData("9. LIMITATIONS ON SERVICE\n",3));

        list.add(new TermsData("You acknowledge that Mekvahan may establish limits concerning use of the Service, including the maximum number of days that Content will be retained by the Service, the maximum number and size of postings, email messages, or other Content that may be transmitted or stored by the Service, and the frequency with which you may access the Service. You agree that Mekvahan has no responsibility or liability for the deletion or failure to store any Content maintained or transmitted by the Service. You acknowledge that Mekvahan reserves the right at any time to modify or discontinue the Service (or any part thereof) with or without notice, and that Mekvahan shall not be liable to you or to any third party for any modification, suspension or discontinuance of the Service.\n",2));

        list.add(new TermsData("10. ACCESS TO THE SERVICE\n",3));

        list.add(new TermsData("Mekvahan grants you a limited, revocable, non-exclusive license to access the Service for your own personal use. This license does not include any collection, aggregation, copying, duplication, display or derivative use of the Service nor any use of data mining, robots, spiders, or similar data gathering and extraction tools for any purpose unless expressly permitted by Mekvahan. A limited exception is provided to general purpose internet search engines and non-commercial public archives that use such tools to gather information for the sole purpose of displaying hyperlinks to the Service, provided they each do so from a stable IP address or range of IP addresses using an easily identifiable agent and comply with our robots.txt file. \"General purpose internet search engine\" does not include a website or search engine or other service that specializes in classified listings or in any subset of classifieds listings such as jobs, housing, for sale, services, or personnel, or which is in the business of providing classified ad listing services.\n",2));

        list.add(new TermsData("Mekvahan permits you to display on your website, or create a hyperlink on your website to, individual postings on the Service so long as such use is for non-commercial and/or news reporting purposes only (e.g., for use in personal web blogs or personal online media).\n",2));

        list.add(new TermsData("11. TERMINATION OF SERVICE\n",3));

        list.add(new TermsData("You agree that Mekvahan, in its sole discretion, has the right (but not the obligation) to delete or deactivate your account, block your email or IP address, or otherwise terminate your access to or use of the Service (or any part thereof), immediately and without notice, and remove and discard any Content within the Service, for any reason, including, without limitation, if Mekvahan believes that you have acted inconsistently with the letter or spirit of the Terms. Further, you agree that Mekvahan shall not be liable to you or any third-party for any termination of your access to the Service. Further, you agree not to attempt to use the Service after said termination. Sections 2, 4, 6 and 10-16 shall survive termination of these Terms.\n",2));

        list.add(new TermsData("Please read clause 32 (below) for termination period for customer,dealer, other companies.\n",2));

        list.add(new TermsData("12. PROPRIETARY RIGHTS\n",3));

        list.add(new TermsData("The Service is protected to the maximum extent permitted by copyright laws and international treaties. Content displayed on or through the Service is protected by copyright as a collective work and/or compilation, pursuant to copyright laws, and international conventions. Any reproduction, modification, creation of derivative works from or redistribution of the site or the collective work, and/or copying or reproducing the sites or any portion thereof to any other server or location for further reproduction or redistribution is prohibited without the express written consent of Mekvahan. You further agree not to reproduce, duplicate or copy Content from the Service without the express written consent of Mekvahan, and agree to abide by any and all copyright notices displayed on the Service. You may not decompile or disassemble, reverse engineer or otherwise attempt to discover any source code contained in the Service. Without limiting the foregoing, you agree not to reproduce, duplicate, copy, sell, resell or exploit for any commercial purposes, any aspect of the Service. \n",2));

        list.add(new TermsData("Although Mekvahan does not claim ownership of content that its users post, by posting Content to any public area of the Service, you automatically grant, and you represent and warrant that you have the right to grant, to Mekvahan an irrevocable, perpetual, non-exclusive, fully paid, worldwide license to use, copy, perform, display, and distribute said content and to prepare derivative works of, or incorporate into other works, said content, and to grant and authorize sublicenses (through multiple tiers) of the foregoing. Furthermore, by posting content to any public area of the Service, you automatically grant Mekvahan all rights necessary to prohibit any subsequent aggregation, display, copying, duplication, reproduction, or exploitation of the Content on the Service by any party for any purpose.\n",2));

        list.add(new TermsData("13. DISCLAIMER OF WARRANTIES\n",3));

        list.add(new TermsData("YOU AGREE THAT the USE OF THE Mekvahan SITE AND THE SERVICE IS ENTIRELY AT YOUR OWN RISK. THE Mekvahan SITE AND THE SERVICE ARE PROVIDED ON AN \"AS IS\" OR \"AS AVAILABLE\" BASIS, WITHOUT ANY WARRANTIES OF ANY KIND. ALL EXPRESS AND IMPLIED WARRANTIES, INCLUDING, WITHOUT LIMITATION, THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE, AND NON-INFRINGEMENT OF PROPRIETARY RIGHTS ARE EXPRESSLY DISCLAIMED TO THE FULLEST EXTENT PERMITTED BY LAW. TO THE FULLEST EXTENT PERMITTED BY LAW, Mekvahan DISCLAIMS ANY WARRANTIES FOR THE SECURITY, RELIABILITY, TIMELINESS, ACCURACY, AND PERFORMANCE OF THE Mekvahan SITE AND THE SERVICE. TO THE FULLEST EXTENT PERMITTED BY LAW, Mekvahan DISCLAIMS ANY WARRANTIES FOR OTHER SERVICES OR GOODS RECEIVED THROUGH OR ADVERTISED ON THE Mekvahan SITE OR THE SITES OR SERVICE, OR ACCESSED THROUGH ANY LINKS ON THE Mekvahan SITE. TO THE FULLEST EXTENT PERMITTED BY LAW, Mekvahan DISCLAIMS ANY WARRANTIES FOR VIRUSES OR OTHER HARMFUL COMPONENTS IN CONNECTION WITH THE Mekvahan SITE OR THE SERVICE. Some jurisdictions do not allow the disclaimer of implied warranties. In such jurisdictions, some of the foregoing disclaimer may not apply to you in so far as they relate to implied warranties.\n",2));

        list.add(new TermsData("14. LIMITATIONS OF LIABILITY\n",3));

        list.add(new TermsData("UNDER NO CIRCUMSTANCES SHALL Mekvahan BE LIABLE FOR DIRECT, INDIRECT, INCIDENTAL, SPECIAL, CONSEQUENTIAL OR EXEMPLARY DAMAGES (EVEN IF Mekvahan HAS BEEN ADVISED OF THE POSSIBILITY OF SUCH DAMAGES), RESULTING FROM ANY ASPECT OF YOUR USE OF THE Mekvahan SITE OR THE SERVICE, WHETHER THE DAMAGES ARISE FROM the USE OR MISUSE OF THE Mekvahan SITE OR THE SERVICE, FROM INABILITY TO USE THE Mekvahan SITE OR THE SERVICE, OR THE INTERRUPTION, SUSPENSION, MODIFICATION, ALTERATION, OR TERMINATION OF THE Mekvahan SITE OR THE SERVICE. SUCH LIMITATION SHALL ALSO APPLY WITH RESPECT TO DAMAGES INCURRED BY REASON OF OTHER SERVICES OR PRODUCTS RECEIVED THROUGH OR ADVERTISED IN CONNECTION WITH THE Mekvahan SITE OR THE SERVICE OR ANY LINKS ON THE Mekvahan SITE, AS WELL AS BY REASON OF ANY INFORMATION OR ADVICE RECEIVED THROUGH OR ADVERTISED IN CONNECTION WITH THE Mekvahan SITE OR THE SERVICE OR ANY LINKS ON THE Mekvahan SITE. THESE LIMITATIONS SHALL APPLY TO THE FULLEST EXTENT PERMITTED BY LAW. In some jurisdictions, limitations of liability are not permitted. In such jurisdictions, some of the foregoing limitation may not apply to you.\n",2));

        list.add(new TermsData("15. INDEMNITY\n",3));

        list.add(new TermsData("You agree to indemnify and hold the Company, its officers, subsidiaries, affiliates, successors, assigns, directors, officers, agents, service providers, suppliers and employees, harmless from any claim or demand, including reasonable attorney fees and court costs, made by any third party due to or arising out of Content you submit, post or make available through the Service, your use of the Service, your violation of the Terms, your breach of any of the representations and warranties herein, or your violation of any rights of another.\n",2));

        list.add(new TermsData("16. GENERAL INFORMATION\n",3));

        list.add(new TermsData("The Terms constitute the entire agreement between you and Mekvahan and govern your use of the Service, superseding any prior agreements between you and Mekvahan. The Terms and the relationship between you and Mekvahan shall be governed by the Indian laws without regard to its conflict of law provisions. You and Mekvahan agree to submit to the personal and exclusive jurisdiction of the courts located within India. The failure of Mekvahan to exercise or enforce any right or provision of the Terms shall not constitute a waiver of such right or provision. If any provision of the Terms is found by a court of competent jurisdiction to be invalid, the parties nevertheless agree that the court should endeavour to give effect to the parties' intentions as reflected in the provision, and the other provisions of the Terms remain in full force and effect. You agree that regardless of any statute or law to the contrary, any claim or cause of action arising out of or related to use of the Service or the Terms must be filed within one (1) year after such claim or cause of action arose or be forever barred.\n",2));

        list.add(new TermsData("The Promoter and Promoter Affiliates are not liable for any problems or technical malfunction of any telephone network or lines, computer online systems, servers or providers, computer equipment, software, technical problems or traffic congestion on the Internet or at any website, or any combination thereof, including any injury or damage to participants or any other person's computer related to or resulting from participation in or downloading any materials in this promotion. This does not apply to liability for fraud, gross negligence or for death or personal injury caused by the Promoter or Promoter's Affiliates negligence or any other liability which cannot be excluded by law. The Promoter is Udyamat Ma Viramasva Pvt. Ltd. having its registered office at Ph-4, Aya Nagar Extn.,Delhi-110047, CIN: U63030DL2018PTC333382, PAN : AACCU2431Q\n",2));

        list.add(new TermsData("Mekvahan.com concept is to give choices to customers and customer is not bound to go to any particular outlets/company.\n",2));

        list.add(new TermsData("19. Terms and conditions for Motor Vehicle Helpline- On-Road Assistance\n",3));

        list.add(new TermsData("Mekvahan associated with Car/bike On-Road Emergency Service Companies and do not provide this service itself.\n",2));

        list.add(new TermsData("This service is provided as per terms and conditions stated by Car/bike Emergency Breakdown Company.\n",2));

        list.add(new TermsData("All disputes arising from this \"value added services\" should be dealt directly with associated companies.\n",2));

        list.add(new TermsData("Services are available within border areas of Delhi & NCR.\n",2));

        list.add(new TermsData("Services will be provided only when the vehicle develops fault while on the road. Mekvahan does not guarantee any reach time for service provided.\n",2));

        list.add(new TermsData("It’s mandatory for the customer making helpline call to produce either the card or the sticker to avail the required services.\n",2));

        list.add(new TermsData("If the vehicle is repairable on road, free towing/dropping service will not be provided.\n",2));

        list.add(new TermsData("Wheel tube repair services will be provided for a flat tyre at actual cost.\n",2));

        list.add(new TermsData("Claims/Refunds if any will not be exceed the residual value (on per day prorated basis of Card validity period) of the card fees paid by the Cardholder as on the date of the claim.\n",2));

        list.add(new TermsData("It will be considered that all the terms & conditions are accepted by the cardholder once the services are utilized by him even if the card subscription form does not reach this office duly filled in and signed by the Cardholder concerned.\n",2));

        list.add(new TermsData("Service of opening of cars with keys locked inside or bike key lost will be given if possible with standard tools available.\n",2));

        list.add(new TermsData("Towing of vehicle may not be provided between 8 am to 11 am and 5 pm to 8 pm or any other restriction imposed by the traffic police, and towing shall at no point of time be free. The Customer will have to pay the rate stipulated.\n",2));

        list.add(new TermsData("Vehicles older than 15 years at the time of enrolling shall not be accepted for service.\n",2));

        list.add(new TermsData("The company will try and ensure to provide service within the stipulated time of 30 minutes but it cannot be held responsible for any delay arising due to conditions not within its control.\n",2));

        list.add(new TermsData("The customer or its representative will have no claim against the company or its representative either civil or criminal nature or pursuant to this card in respect of death or injury of the customer or any other person or loss or damage to any other property caused by or due to equipment failure, breakdown or accident or fire on utilization of services during the validity of the card.\n",2));

        list.add(new TermsData("Receipts for cost of Petrol/Diesel will not be provided.\n",2));

        list.add(new TermsData("Above terms are general for all car/bike breakdown memberships. It varies for different vendors/companies, please check offers detail when you receive car/bike breakdown card membership.\n",2));

        list.add(new TermsData("20. Special Offers Campaign / Hot Deals\n",3));

        list.add(new TermsData("20.1.Mekvahan runs campaigns from time to time at all occasions for awareness and promotional purposes.\n",2));

        list.add(new TermsData("20.2. Motor Vehicle owners need to provide information required to be eligible for FREE & Discount offers\n",2));

        list.add(new TermsData("20.3. Free Motor Vehicle Servicing coupons are sent through courier or web based service. These are limited time campaigns.\n",2));

        list.add(new TermsData("20.4. Offers are limited to areas, please call Mekvahan helpline to check areas and Service vendors and company associated with value added services.\n",2));

        list.add(new TermsData("20.5. Mekvahan promotes associates companies in the offer. Please check separate terms and conditions of partner companies.\n",2));

        list.add(new TermsData("20.6. Please read the terms and conditions before buying offers online. Mekvahan.com cannot guarantee for other services not mentioned in the offer.\n",2));

        list.add(new TermsData("20.7. Once purchase any offer online, Mekvahan.com team dispatch coupons through courier/post or suggest online print.\n",2));

        list.add(new TermsData("20.8. There is no refund if coupons are delivered or emailed. Customer can demand courier tracking number or resend of email with links of coupons. Refund is given in case of non-receive of offer coupons or other company acceptable conditions.\n",2));

        list.add(new TermsData("20.9. Free paid service offers are at selected workshops. Please check on our website or the app or by calling or asking for a list of workshops offering the same. Free Paid service means \"free labour charges\", it does not include any consumable.\n",2));

        list.add(new TermsData("20.10. It is not necessary that all mentioned services in the brochure are available at one workshop, some services are specialized and available at few workshops. Please check availability and workshops before buying offer.\n",2));

        list.add(new TermsData("20.11. Mekvahan NEVER sell coupons in the retail market to avoid mis-use of it, those coupons are sent through courier/post or send through online.\n",2));

        list.add(new TermsData("20.12. Mekvahan will not take any guarantee to serve customers if they buy any offer from \"duplicate\", \"pirated\" sources. Few agencies duplicate offers and try to sell in the market. Customer must call Mekvahan helpdesk before buying any offer.\n",2));

        list.add(new TermsData("21. Do-It-Yourself and Motor Vehicle Care Tips or Articles\n",3));

        list.add(new TermsData("The information contained in car/bike care articles, tips, do-it-yourself guide, is for knowledge and educational purposes only and cannot substitute for the advice of professional car/bike / auto mechanic or authorized car/bike workshop or dealer or service station. Please don't attempt to service your car/bike if you don't have proper knowledge and tools, you can be injured and your vehicle could be damaged. Take your car/bike to a dealer or a repair shop.\n",2));

        list.add(new TermsData("Dealer Grading / Ranking / Reviews\n",3));

        list.add(new TermsData("To make system transparent for customers/ visitors, Mekvahan ranks Service vendors/service centres/repair shops based on a formula which is based on two criteria: \n",2));

        list.add(new TermsData("1. Customer satisfaction. 2. Aggression/communication/Conversion. The dealer who has more customer satisfaction and aggression to serve customer will get a higher rank than others. Formula for ranking may change as we get more analysis to provide customer more transparency for \"the right workshop\" or \"service\". There is no guarantee for accuracy of the ranking but Mekvahan would help customers to meet the best with transparent system.\n",2));

        list.add(new TermsData("Privileged Customer Program\n",3));

        list.add(new TermsData("Loyal/Privileged Customer Membership program is launched to provide more reliability and help customers with Mekvahan services as \"one-stop-shop\" concept. Please read all terms and conditions and service offered in the Mekvahan brochure.\n",2));

        list.add(new TermsData("22. Bounced Emails / Problem with emails / spam mails.\n",3));

        list.add(new TermsData("Mekvahan technical team tries to maintain email hosting space, but in rare cases because of huge responses email storage or other unseen circumstances, email hosting server may behave differently because of any reason like shortage of space etc. Any customer can get some bounced email messages because of full of hosting emails storage or any other reason. Please inform us for any unsubscribe issue or if you are receiving Mekvahan email as spam. Mekvahan team has no intention to send spam mails. We will take immediate action to stop spam. Spamming may be because of any technical reason, your email box may not be considering Mekvahan.com host as genuine even if this is hosted at reputed IP and host. Since email technology varies from company to company, so it cannot be controlled. Some email box shows one email coming from genuine but same email in another mailbox can be a spam.\n",2));

        list.add(new TermsData("To receive emails into your email box as non-spam, please send feedback to your Email Service Provider with tag spam and non-spam (as per their rules to tag them).\n",2));

        list.add(new TermsData("Unwanted mails\n",3));

        list.add(new TermsData("Mekvahan.com technical team use secure standard code and caches to prevent hacking or mis-use of web form and update code from time-to-time with recent technology. In case of receipt of any unwanted mail from Mekvahan domain, it should be informed with a URL of the page to help us preventing mis-use of web forms.\n",2));

        list.add(new TermsData("23. REFUND POLICY\n",3));

        list.add(new TermsData("Cancellation/Refund policy :- Mekvahan believes in helping its customers as far as possible, and has therefore a liberal cancellation/refund policy.\n",2));

        list.add(new TermsData("Cancellation Policy:-\n",3));

        list.add(new TermsData("Under this policy:\n",3));

        list.add(new TermsData("Cancellation request can be made via the Mekvahan Mobile Application to make a booking or via call or e-mail to care@mekvahan.com.\n",2));

        list.add(new TermsData("Cancellations will be considered only if the request is made before the car has been\n",2));

        list.add(new TermsData("picked up by the Mekvahan’s on-field Executive.\n",2));

        list.add(new TermsData("In case pickup/drop service is availed, a cancellation fee of INR 99.00 will be charged\n",2));

        list.add(new TermsData("once the cancellation request is accepted by Mekvahan.\n",2));

        list.add(new TermsData("Cancellation request will not be entertained if the orders have been communicated to the vendors/merchants and they have initiated the services. However, in case you have\n",2));

        list.add(new TermsData("agreed to your booking and service is being provided to your car and you choose to\n",2));

        list.add(new TermsData("cancel while the service is still in progress, you have to pay Mekvahan or it’s partnered\n",2));

        list.add(new TermsData("workshop the total amount for the service done.\n",2));

        list.add(new TermsData("In case of cancellation is made via phone call, cancellation is to be deemed accepted by\n",2));

        list.add(new TermsData("Mekvahan only if the user receives a confirmation email/sms on the registered email\n",2));

        list.add(new TermsData("id/phone number. In case the e-mail/sms is not received by user, booking will stand Confirmed\n",2));

        list.add(new TermsData("Refund Policy\n",3));

        list.add(new TermsData("Under this policy:\n",3));

        list.add(new TermsData("Refund can be claimed only after service order cancellation.\n",2));

        list.add(new TermsData("Refund will be made only if the cancellation is done before initiating the services by the Service Station.\n",2));

        list.add(new TermsData("In case you feel that the service received is not satisfactory or is not as per your\n" +
                "expectations, you must bring it to the notice of our customer service by dropping a mail\n" +
                "to care@mekvahan.com within 24 hours of receiving the service. The Customer Service\n" +
                "Team after looking into your complaint will take an appropriate decision.\n",2));

        list.add(new TermsData("Once a job is completed we will not accept any return or refund request. However\n" +
                "there may be certain circumstances where if we feel upon investigation that the service\n" +
                "provided was faulty or not up to the standard we may accept partial or complete refund\n" +
                "of the service/repair job amount. The nature and acceptance of refund remains on sole\n" +
                "discretion of Mekvahan.\n",2));

        list.add(new TermsData("In case of complaints regarding service parts that come with a warranty from\n" +
                "manufacturers, please refer the issue to the concerned Manufacturing Company.\n",2));

        list.add(new TermsData("Prepaid Service Cancellation Refund (if applicable)",3));

        list.add(new TermsData(" In case of the cancellation of the service if the payment was prepaid and the pickup was not done, we will not charge any cancellation charges and we will refund your money.",2));

        list.add(new TermsData("If you haven’t received a refund yet, first check your bank account again. Then contact " +
                "your credit card company, it may take some time before your refund is officially " +
                "posted. Next contact your bank. ",2));

        list.add(new TermsData(" There is often some processing time before a refund is posted. If you’ve done all of this " +
                "and you still have not received your refund yet, please contact us at care@mekvahan.com\n",2));

        list.add(new TermsData("No Refund Policy Cases (Applicable to all services contracts)",3));

        list.add(new TermsData("EXPIRY Contract.\n",2));

        list.add(new TermsData("Non Receive of Application through proper channel (email/post)\n",2));

        list.add(new TermsData("Receive of Some Services or Deliverables.\n",2));

        list.add(new TermsData("Pressurising staff/employee in a wrong way.\n",2));

        list.add(new TermsData("Defame company without prior request to company.\n",2));

        list.add(new TermsData("FOR DEALER/WORKSHOP/OUTLET\n",3));

        list.add(new TermsData("No refund for EXPIRY contract.\n",2));

        list.add(new TermsData("Forcing/pushing company or individual (by wrong way of pressure/force) for refund is considered to be illegal and No refund will be claimed if proven wrong way of pressure on any associate / employee/staff.\n",2));

        list.add(new TermsData("Mekvahan.com is promotion/marketing company and do not guarantee for any amount of business until specified in the contract.\n",2));

        list.add(new TermsData("Dealer/Workshop/merchant/outlets can request for refund using proper channel of the company/process and cannot force/push/pressure/coerce anybody for refund.\n",2));

        list.add(new TermsData("However, Mekvahan does not guarantee any refund, and it merely facilitates.\n",2));

        list.add(new TermsData("FOR CUSTOMER MEMBERSHIPS\n",3));

        list.add(new TermsData("Customer memberships includes services provided by Merchant/Workshop/Dealer/Outlet so Mekvahan can help customers servicing them, but cannot take guarantee for their quality of services.\n",2));

        list.add(new TermsData("Customer can ask for refund in case of SERVICES not been offered.\n",2));

        list.add(new TermsData("Once all memberships coupons/cards/material sent to customer or delivered, customer cannot ask for refund until they have not been serviced by merchant/members/workshop/outlet.\n",2));

        list.add(new TermsData("In case of problems with quality of workshop service, Mekvahan.com can mediate dispute but the customer cannot claim for any refund or settlement from Mekvahan.com. \n",2));

        list.add(new TermsData("Mekvahan.com is doing regular effort to bring BEST merchant/workshops/outlet on one platform as a concept, but customer members need to check themselves if merchant/workshop/outlet is serving as per commitment. Mekvahan.com ask for feedback and try to resolve dispute (with mutual consent from both parties-customer and workshop), but cannot take guarantee for every service.\n",2));

        list.add(new TermsData("FOR EXCLUSIVE PARTNERSHIP / LONG TERM CONTRACT TERMINATION\n",3));

        list.add(new TermsData("Exclusive Contract / Corporate company can request for refund using proper channel of the company/process.\n",2));

        list.add(new TermsData("Refund will be paid after adjustment of work done by Mekvahan.com team.\n",2));

        list.add(new TermsData("Refund shall be requested within 3 months’ notice period of Termination of the contract, as stated in the contract.\n",2));

        list.add(new TermsData("Minimum 3 months shall be considered for refund.\n",2));

        list.add(new TermsData("Termination letter shall be written officially and duly signed by the authority of the company.\n",2));

        list.add(new TermsData("Forcing/pushing company or individual (by wrong way of pressure/force) for refund is considered to be illegal.\n",2));

        list.add(new TermsData("\nNOTE: We update these terms from time-to-time, regularly and all customers/visitors at Mekvahan agrees to read it when required and company will not inform separately for any updates of these Terms and Conditions.\n",2));

    }

}
