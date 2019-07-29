package com.naruto.mekvahandelivery.Help_And_Support;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.Layout;
import android.text.SpannableString;
import android.text.style.AlignmentSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.naruto.mekvahandelivery.R;

public class Disclaimer extends AppCompatActivity {

    private TextView disclaimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.disclaimer_activity);

        disclaimer = findViewById(R.id.txtdisclaimer);

        String disclam = "DISCLAIMER:\n" +
                "\n" +
                "Service Plans / Charges are subject to revision by Mekvahan without prior notice.\n" +
                "Mekvahan does not provide any Warranties / Guarantees or liabilities to its customers for services. No claim from vehicles owner side will be borne by Mekvahan or its members/employee/owner in any manner. Our services are provided at vehicle owners risk and he/she/it understands and accept the same at the time / before taking any services from us. A vehicle owner cannot claim for any warranties/guarantees in any manner. Mekvahan will be no more liable for any damage/discrepancy. Mekvahan will not be liable for any discrepancy in service as the customer is accepting services at its own risk. Mekvahan will also not be liable for the loss of any valuables in the vehicle.\n" +
                "Mekvahan customer database and related information will not be shared with anyone. However, the data may be shared for statutory obligations.\n" +
                "Mekvahan would use standard products for the cleaning process. Mekvahan has the right to add/delete/amend the terms and conditions above in the best interest of both the company and its customers.\n" +
                "The customer is aware that in any circumstances the bill amount shall not be refunded. The same bill amount steam car wash facility shall be available to the Customer on the alternative day of his choice.   \n" +
                "If the customer is not satisfied with services provided by MEKVAHAN, the customer should tell us about his complaint through our website www.mekvahan.com, we will try to respond to his dispute within 02 business days.\n" +
                "\n" +
                "Mekvahan reserves the right to cancel any scheme, for any reason at any time without notice.\n" +
                "The information, software, products, and services included in or available through the Mekvahan  website may include inaccuracies or typographical errors. Changes are periodically added to the information herein Mekvahan and/or its suppliers may make improvements and/or changes in the Mekvahan website at any time. Advice received via the Mekvahan website should not be relied upon for personal, medical, legal or financial decisions and you should consult an appropriate professional for specific advice tailored to your situation. Mekvahan make no representations about the suitability, reliability, availability, timeliness and accuracy of the information, software, products, services and related graphics contained on the website for any purpose. If you are dissatisfied with any portion of the Mekvahan website, or with any of these terms of use, your sole and exclusive remedy is to discontinue using the website. \n" +
                "\n" +
                "Liability: Please be aware and understand that Mekvahan cannot be held responsible or liable for the pre-existing condition of your vehicle Or Damage occurred during wash due to wear and tear of the vehicle or by nature. MEKVAHAN cannot be held liable for any damage occurred  due to the certain condition that affected.( Such as heated Windshield may crack with wash, Scratches most often not visible before wash can be visible after wash and etc.) \n" +
                "\n" +
                "This includes, but is not limited to: pre-existing damage, alarm systems, oxidized or bad paint, loose moldings (any and all), windshields, windshield wipers, bug shields (as they age and crack), rear view mirrors with weak glue, antennas, batteries, any and all engine issues after cleaning, cloth or vinyl convertible tops.\n" +
                "\n" +
                "\n" +
                "EXCEPT AS PROVIDED IN THE LIMITED WARRANTY, THE SERVICE AND PARTS ARE MADE AVAILABLE ON AN “AS IS,” “AS AVAILABLE,” AND “WITH ALL FAULTS” BASIS, WITHOUT ANY WARRANTIES OR CONDITIONS, EXPRESS, IMPLIED OR STATUTORY. YOU USE THE SERVICES ENTIRELY AT YOUR OWN RISK. WE DO NOT PROVIDE, AND SPECIFICALLY DISCLAIM, ANY REPRESENTATION OR WARRANTY OF ANY KIND TO YOU OR ANY OTHER PERSON OR ENTITY, INCLUDING, BUT NOT LIMITED TO, ANY EXPRESS OR IMPLIED warranties (I) OF MERCHANTABILITY OR FITNESS FOR A PARTICULAR PURPOSE; (II) OF INFORMATIONAL CONTENT OR ACCURACY; (III) OF NON-INFRINGEMENT; (IV) OF QUIET ENJOYMENT; (V) OF TITLE; (VI) THAT THE MEKVAHAN  PLATFORM WILL OPERATE ERROR-FREE, OR IN AN UNINTERRUPTED FASHION; (VII) THAT ANY DEFECTS OR ERRORS IN THE  PLATFORM WILL BE CORRECTED; (VIII) THAT SERVICES OFFERED WILL BE AVAILABLE IN ALL MARKETS; OR (IX) THAT THE  PLATFORM IS COMPATIBLE WITH ANY PARTICULAR HARDWARE OR SOFTWARE. MEKVAHAN  MAKES NO REPRESENTATION, WARRANTY, OR GUARANTEE REGARDING THE RELIABILITY, TIMELINESS, QUALITY, SUITABILITY, OR AVAILABILITY OF THE SERVICES OR ANY SERVICES OR GOODS REQUESTED THROUGH THE USE OF THE SERVICES, OR THAT THE SERVICES WILL BE UNINTERRUPTED OR ERROR-FREE. MEKVAHAN  DOES NOT GUARANTEE THE QUALITY, SUITABILITY, SAFETY OR ABILITY OF THIRD PARTY PROVIDERS. YOU AGREE THAT THE ENTIRE RISK ARISING OUT OF YOUR USE OF THE SERVICES, AND ANY SERVICE OR GOOD REQUESTED IN CONNECTION THEREWITH, REMAINS SOLELY WITH YOU, TO THE MAXIMUM EXTENT PERMITTED UNDER APPLICABLE LAW. \n" +
                "\n" +
                "Limitations of Liability \n" +
                "\n" +
                "YOU AGREE NOT TO HOLD MEKVAHAN  (OR, ITS STOCKHOLDERS, AFFILIATES, LICENSORS, PARTNERS, MEMBERS, DIRECTORS, MANAGERS, OFFICERS, EMPLOYEES, AGENTS, SUCCESSORS, ASSIGNS AND CONTENT PROVIDERS (COLLECTIVELY, \"MEMBERS\")) LIABLE FOR ANY DAMAGES, EXPENSES, LOSSES, SUITS, CLAIMS, AND/OR CONTROVERSIES THAT HAVE ARISEN OR MAY ARISE, WHETHER KNOWN OR UNKNOWN, RELATING TO YOUR USE OF OR INABILITY TO USE THE MEKVAHAN  PLATFORM OR ANY SERVICES, INCLUDING WITHOUT LIMITATION ANY LIABILITIES ARISING IN CONNECTION WITH THE CONDUCT, ACT, DELAY OF PERFORMANCE OR OMISSION OF ANY USER OR THIRD PARTY PROVIDER (OR ANY TRANSACTION OR RELATIONSHIP BETWEEN YOU AND ANY THIRD PARTY PROVIDER), ANY DISPUTE WITH ANY USER OR THIRD PARTY PROVIDER, ANY INSTRUCTION, ADVICE, ACT, OR SERVICE PROVIDED BY MEKVAHAN  OR MEMBERS, AND ANY DESTRUCTION OF YOUR INFORMATION. \n" +
                "\n" +
                "UNDER NO CIRCUMSTANCES WILL MEKVAHAN  OR MEMBERS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, CONSEQUENTIAL, SPECIAL, PUNITIVE OR EXEMPLARY DAMAGES, HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN AN ACTION FOR CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE) OR OTHERWISE, INCLUDING WITHOUT LIMITATION LOST PROFITS, LOST EARNINGS, LOST DATA, PERSONAL INJURY, OR PROPERTY DAMAGE, WHETHER OR NOT WE HAVE BEEN ADVISED OF THE POSSIBILITY OF SUCH DAMAGES. MEKVAHAN  AND MEMBERS DO NOT ACCEPT ANY LIABILITY WITH RESPECT TO THE QUALITY OR FITNESS OF ANY WORK PERFORMED IN CONNECTION WITH THE MEKVAHAN  PLATFORM. \n" +
                "\n" +
                "THE MEKVAHAN  PLATFORM IS ONLY A VENUE FOR CONNECTING USERS. WE ARE NOT RESPONSIBLE FOR ASSESSING THE SUITABILITY, LEGALITY OR ABILITY OF ANY THIRD PARTY PROVIDER AND YOU EXPRESSLY WAIVE AND RELEASE MEKVAHAN  FROM ANY AND ALL LIABILITY, CLAIMS OR DAMAGES (ACTUAL, DIRECT OR CONSEQUENTIAL) OF EVERY KIND AND NATURE, KNOWN AND UNKNOWN, SUSPECTED AND UNSUSPECTED, DISCLOSED AND UNDISCLOSED, ARISING FROM OR IN ANY WAY RELATED TO ANY THIRD PARTY PROVIDER. WE EXPRESSLY DISCLAIM ANY LIABILITY THAT MAY ARISE BETWEEN YOU AND ANY THIRD PARTY PROVIDER. THE QUALITY OF THE SERVICES SCHEDULED OR REQUESTED THROUGH THE USE OF THE MEKVAHAN  PLATFORM IS ENTIRELY THE RESPONSIBILITY OF THE THIRD PARTY PROVIDER WHO ULTIMATELY PROVIDES SUCH SERVICES TO YOU. YOU UNDERSTAND, THEREFORE, THAT BY USING THE MEKVAHAN  PLATFORM, YOU MAY BE EXPOSED TO SERVICES THAT ARE POTENTIALLY DANGEROUS, OFFENSIVE, HARMFUL, UNSAFE OR OTHERWISE OBJECTIONABLE, AND THAT YOU USE THE MEKVAHAN  PLATFORM, AND THIRD PARTY PROVIDER, AT YOUR OWN RISK. NOTHING IN THIS AGREEMENT OR THE MEKVAHAN  PLATFORM CONSTITUTES, OR IS MEANT TO CONSTITUTE, ADVICE OF ANY KIND. IF YOU REQUIRE ADVICE IN RELATION TO ANY LEGAL, FINANCIAL OR MEDICAL MATTER YOU SHOULD CONSULT AN APPROPRIATE PROFESSIONAL. \n" +
                "\n" +
                "YOU ACKNOWLEDGE THAT THIRD PARTY PROVIDERS MAY NOT BE PROFESSIONALLY LICENSED OR PERMITTED. YOU AGREE THAT WE HAVE NO RESPONSIBILITY OR LIABILITY TO YOU RELATING TO VEHICLE SERVICES PROVIDED TO YOU BY THIRD PARTY PROVIDERS OTHER THAN AS EXPRESSLY SET FORTH IN THESE TERMS. \n" +
                "\n" +
                "SOME JURISDICTIONS DO NOT ALLOW THE EXCLUSION OR LIMITATION OF CERTAIN TYPES OF DAMAGES, SO THE ABOVE limitation MAY NOT APPLY TO YOU. IF, NOTWITHSTANDING THE FOREGOING EXCLUSIONS, IT IS DETERMINED THAT MEKVAHAN  OR MEMBERS ARE LIABLE FOR DAMAGES, IN NO EVENT WILL THE AGGREGATE AND TOTAL LIABILITY, WHETHER ARISING IN CONTRACT, TORT, STRICT LIABILITY OR CAUSE OF ACTION, EXCEED THE AMOUNT INVOICED FOR THE ASSOCIATED JOB. \n" +
                "\n" +
                "BY USING THE (MEKVAHAN  PLATFORM) , YOU AGREE THAT THE EXCLUSIONS AND LIMITATIONS OF LIABILITY SET OUT IN THIS AGREEMENT ARE REASONABLE. IF YOU DO NOT BELIEVE THEY ARE REASONABLE, YOU MUST NOT USE THE  MEKVAHAN  PLATFORM.\n";


        SpannableString spannableString = new SpannableString(disclam);

        spannableString.setSpan(new RelativeSizeSpan(1.3f),0,11,0);
        spannableString.setSpan(new UnderlineSpan(),0,11,0);
        spannableString.setSpan(new StyleSpan(Typeface.BOLD),0,8520,0);
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
//            spannableString.setSpan(new AlignmentSpan.Standard(Layout.Alignment.ALIGN_LEFT),0,8520,0);
//        }
//
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
//            spannableString.setSpan(new AlignmentSpan.Standard(Layout.Alignment.ALIGN_LEFT),0,8520,0);
//        }

        disclaimer.setText(spannableString);
        //Action Bar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#ffffff")));
        actionBar.setTitle(Html.fromHtml("<Font color='#000000'>Disclaimer</Font>"));

        final Drawable upArrow =  ContextCompat.getDrawable(this, R.drawable.ic_keyboard_backspace_black_24dp);
        upArrow.setColorFilter(ContextCompat.getColor(this, R.color.chart_deep_red), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);

    }
}
