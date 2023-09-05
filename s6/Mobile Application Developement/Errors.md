# Διόρθωση σφαλμάτων

Υπάρχει η διαδικασία του Debugging για να δεις πως εκτελείται η εφαρμογή. Εδώ θα δούμε μια διαφορετική προσέγγιση. Αν σας κρασάρει η εφαρμογή, πατήστε το **Logcat** για να δείτε τα logs του σφάλματος.   

## Το πιο συνηθισμένο σφάλμα είναι το **java.lang.NullPointerException**. 

Ας δούμε ένα παράδειγμα. Το παρακάτω είναι το μήνυμα από το logcat.   
```
java.lang.RuntimeException: Unable to instantiate activity ComponentInfo{gr.uom.randomnumber/gr.uom.randomnumber.SecondActivity}: 
java.lang.NullPointerException: Attempt to invoke virtual method 'android.content.pm.ApplicationInfo android.content.Context.getApplicationInfo()' on a null object reference
at android.app.ActivityThread.performLaunchActivity(ActivityThread.java:3689)
at android.app.ActivityThread.handleLaunchActivity(ActivityThread.java:3922)
at android.app.servertransaction.LaunchActivityItem.execute(LaunchActivityItem.java:103)
at android.app.servertransaction.TransactionExecutor.executeCallbacks(TransactionExecutor.java:139)
at android.app.servertransaction.TransactionExecutor.execute(TransactionExecutor.java:96)
at android.app.ActivityThread$H.handleMessage(ActivityThread.java:2443)
at android.os.Handler.dispatchMessage(Handler.java:106)
at android.os.Looper.loopOnce(Looper.java:205)
at android.os.Looper.loop(Looper.java:294)
at android.app.ActivityThread.main(ActivityThread.java:8177)
at java.lang.reflect.Method.invoke(Native Method)
at com.android.internal.os.RuntimeInit$MethodAndArgsCaller.run(RuntimeInit.java:552)
at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:971)
Caused by: java.lang.NullPointerException: Attempt to invoke virtual method 'android.content.pm.ApplicationInfo android.content.Context.getApplicationInfo()' on a null object reference
at android.content.ContextWrapper.getApplicationInfo(ContextWrapper.java:206)
at android.view.ContextThemeWrapper.getTheme(ContextThemeWrapper.java:174)
at android.content.Context.obtainStyledAttributes(Context.java:999)
at androidx.appcompat.app.AppCompatDelegateImpl.createSubDecor(AppCompatDelegateImpl.java:922)
at androidx.appcompat.app.AppCompatDelegateImpl.ensureSubDecor(AppCompatDelegateImpl.java:889)
at androidx.appcompat.app.AppCompatDelegateImpl.findViewById(AppCompatDelegateImpl.java:691)
at androidx.appcompat.app.AppCompatActivity.findViewById(AppCompatActivity.java:264)
at gr.uom.randomnumber.SecondActivity.<init>(SecondActivity.java:20)
at java.lang.Class.newInstance(Native Method)
at android.app.AppComponentFactory.instantiateActivity(AppComponentFactory.java:95)
at androidx.core.app.CoreComponentFactory.instantiateActivity(CoreComponentFactory.java:45)
at android.app.Instrumentation.newActivity(Instrumentation.java:1378)
at android.app.ActivityThread.performLaunchActivity(ActivityThread.java:3676)
at android.app.ActivityThread.handleLaunchActivity(ActivityThread.java:3922) 
at android.app.servertransaction.LaunchActivityItem.execute(LaunchActivityItem.java:103) 
at android.app.servertransaction.TransactionExecutor.executeCallbacks(TransactionExecutor.java:139) 
at android.app.servertransaction.TransactionExecutor.execute(TransactionExecutor.java:96) 
at android.app.ActivityThread$H.handleMessage(ActivityThread.java:2443) 
at android.os.Handler.dispatchMessage(Handler.java:106) 
at android.os.Looper.loopOnce(Looper.java:205) 
at android.os.Looper.loop(Looper.java:294) 
at android.app.ActivityThread.main(ActivityThread.java:8177) 
at java.lang.reflect.Method.invoke(Native Method) 
at com.android.internal.os.RuntimeInit$MethodAndArgsCaller.run(RuntimeInit.java:552) 
at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:971)
```

Το σφάλμα που αντιμετωπίζουμε εδώ είναι ένα NullPointerException που παρουσιάζεται κατά την προσπάθεια πρόσβασης στο ApplicationInfo ενός αντικειμένου περιβάλλοντος που είναι null. Αυτό συνήθως υποδεικνύει ότι υπάρχει πρόβλημα με τον τρόπο με τον οποίο αρχικοποιείτε ή χρησιμοποιείτε ένα Context στην κλάση SecondActivity. Ας αναλύσουμε το ίχνος στοίβας σφαλμάτων για να εντοπίσουμε το προβληματικό τμήμα:

```
Caused by: java.lang.NullPointerException: Attempt to invoke virtual method 'android.content.pm.ApplicationInfo android.content.Context.getApplicationInfo()' on a null object reference
	at android.content.ContextWrapper.getApplicationInfo(ContextWrapper.java:206)
	at android.view.ContextThemeWrapper.getTheme(ContextThemeWrapper.java:174)
	at android.content.Context.obtainStyledAttributes(Context.java:999)
	at androidx.appcompat.app.AppCompatDelegateImpl.createSubDecor(AppCompatDelegateImpl.java:922)
	at androidx.appcompat.app.AppCompatDelegateImpl.ensureSubDecor(AppCompatDelegateImpl.java:889)
	at androidx.appcompat.app.AppCompatDelegateImpl.findViewById(AppCompatDelegateImpl.java:691)
	at androidx.appcompat.app.AppCompatActivity.findViewById(AppCompatActivity.java:264)
	at gr.uom.randomnumber.SecondActivity.<init>(SecondActivity.java:20)
```

Το σχετικό μέρος είναι:

```
at gr.uom.randomnumber.SecondActivity.<init>(SecondActivity.java:20)
```

Το σφάλμα παρουσιάζεται στον κατασκευαστή (<init>) της κλάσης SecondActivity σας, συγκεκριμένα στη γραμμή 20. Πρόβλημα ήταν στις ακόλουθες γραμμές:

```
private Button randomButton = findViewById(R.id.randomB);
private Button backbtn = findViewById(R.id.backbtn);
```

Δεν μπορείτε να αρχικοποιήσετε απευθείας προβολές χρησιμοποιώντας το findViewById εκτός μιας μεθόδου ή ενός κατασκευαστή. Ο λόγος είναι ότι αυτές οι εντολές αρχικοποίησης εκτελούνται πριν από τη μέθοδο onCreate και πριν διογκωθεί η διάταξη και είναι διαθέσιμες οι προβολές.   

Για να το διορθώσετε αυτό, μετακινήστε τις γραμμές προετοιμασίας προβολής μέσα στη μέθοδο onCreate, αφού καλέσετε το setContentView για να διογκώσετε τη διάταξη. Ακολουθεί η διορθωμένη έκδοση του κώδικά σας:   

```
public class SecondActivity extends AppCompatActivity {
    ...
    private Button randomButton;
    private Button backbtn;
    
    protected void onCreate(Bundle savedInstanceState) {
       ...
        randomButton = findViewById(R.id.randomB);
        backbtn = findViewById(R.id.backbtn);
       ...
```

Χωρίς να δείτε τον κώδικα της κλάσης SecondActivity, είναι δύσκολο να παράσχετε μια ακριβή λύση. Ωστόσο, ακολουθούν ορισμένα γενικά βήματα για την αντιμετώπιση και επίλυση αυτού του ζητήματος:   

1. **Ελέγξτε την αρχικοποίηση**: Βεβαιωθείτε ότι δεν προσπαθείτε να αποκτήσετε πρόσβαση σε ένα αντικείμενο περιβάλλοντος που δεν έχει προετοιμαστεί σωστά τη στιγμή της δημιουργίας της δραστηριότητας.   

2. **Έλεγχος findViewById**: Το σφάλμα φαίνεται να παρουσιάζεται όταν προσπαθείτε να βρείτε μια προβολή χρησιμοποιώντας το findViewById. Βεβαιωθείτε ότι χρησιμοποιείτε το σωστό αναγνωριστικό πόρου διάταξης και ότι η διάταξη έχει διογκωθεί σωστά.  

3. **Έλεγχος Κατασκευαστών**: Εάν κάνετε κάποια προσαρμοσμένη προετοιμασία στον κατασκευαστή της δραστηριότητάς σας, βεβαιωθείτε ότι δεν προσπαθείτε να αποκτήσετε πρόσβαση στο Πλαίσιο προτού ρυθμιστεί σωστά. Να θυμάστε ότι η πρόσβαση στο Context στον κατασκευαστή ενδέχεται να μην είναι ασφαλής.  

4. **Μέθοδοι κύκλου ζωής**: Είναι γενικά πιο ασφαλές να εκτελείτε λειτουργίες που σχετίζονται με την προβολή σε μεθόδους κύκλου ζωής, όπως onCreate, onStart ή onResume παρά στον κατασκευαστή.   

5. **Κληρονομικότητα**: Εάν το SecondActivity είναι μια υποκατηγορία του AppCompatActivity ή άλλης κατηγορίας δραστηριότητας Android, βεβαιωθείτε ότι καλείτε σωστά τον κατασκευαστή superclass.  

6. **Εντοπισμός σφαλμάτων**: Εισαγάγετε δηλώσεις εκτύπωσης ή χρησιμοποιήστε ένα πρόγραμμα εντοπισμού σφαλμάτων για να παρακολουθήσετε τη ροή του κώδικά σας και να δείτε πού μπορεί να γίνει μηδενικό το πλαίσιο.   

Ελέγξτε τον κώδικα για την κλάση SecondActivity, ειδικά το τμήμα γύρω από τη γραμμή 20, για επίλυση του προβλήματος.


## Ακόμα ένα παράδειγμα java.lang.NullPointerException.

Το παρακάτω είναι το μήνυμα από το logcat.   
```
Process: gr.uom.carpicker_xml_spiner2radio, PID: 23095
java.lang.RuntimeException: Unable to start activity ComponentInfo{gr.uom.carpicker_xml_spiner2radio/gr.uom.carpicker_xml_spiner2radio.SecondActivity}: java.lang.NullPointerException: Attempt to invoke virtual method 'java.util.List gr.uom.carpicker_xml_spiner2radio.CarBrandList.getAllModels(java.lang.String)' on a null object reference
at android.app.ActivityThread.performLaunchActivity(ActivityThread.java:3782)
at android.app.ActivityThread.handleLaunchActivity(ActivityThread.java:3922)
at android.app.servertransaction.LaunchActivityItem.execute(LaunchActivityItem.java:103)
at android.app.servertransaction.TransactionExecutor.executeCallbacks(TransactionExecutor.java:139)
at android.app.servertransaction.TransactionExecutor.execute(TransactionExecutor.java:96)
at android.app.ActivityThread$H.handleMessage(ActivityThread.java:2443)
at android.os.Handler.dispatchMessage(Handler.java:106)
at android.os.Looper.loopOnce(Looper.java:205)
at android.os.Looper.loop(Looper.java:294)
at android.app.ActivityThread.main(ActivityThread.java:8177)
at java.lang.reflect.Method.invoke(Native Method)
at com.android.internal.os.RuntimeInit$MethodAndArgsCaller.run(RuntimeInit.java:552)
at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:971)
Caused by: java.lang.NullPointerException: Attempt to invoke virtual method 'java.util.List gr.uom.carpicker_xml_spiner2radio.CarBrandList.getAllModels(java.lang.String)' on a null object reference
at gr.uom.carpicker_xml_spiner2radio.SecondActivity.onCreate(SecondActivity.java:34)
at android.app.Activity.performCreate(Activity.java:8595)
at android.app.Activity.performCreate(Activity.java:8573)
at android.app.Instrumentation.callActivityOnCreate(Instrumentation.java:1456)
at android.app.ActivityThread.performLaunchActivity(ActivityThread.java:3764)
at android.app.ActivityThread.handleLaunchActivity(ActivityThread.java:3922) 
at android.app.servertransaction.LaunchActivityItem.execute(LaunchActivityItem.java:103) 
t android.app.servertransaction.TransactionExecutor.executeCallbacks(TransactionExecutor.java:139) 
at android.app.servertransaction.TransactionExecutor.execute(TransactionExecutor.java:96) 
at android.app.ActivityThread$H.handleMessage(ActivityThread.java:2443) 
at android.os.Handler.dispatchMessage(Handler.java:106) 
at android.os.Looper.loopOnce(Looper.java:205) 
at android.os.Looper.loop(Looper.java:294) 
at android.app.ActivityThread.main(ActivityThread.java:8177) 
at java.lang.reflect.Method.invoke(Native Method) 
at com.android.internal.os.RuntimeInit$MethodAndArgsCaller.run(RuntimeInit.java:552) 
at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:971) 
```

Το σφάλμα (NullPointerException) στο SecondActivity σας οφείλεται στο γεγονός ότι προσπαθείτε να καλέσετε τη μέθοδο getAllModels σε μια μηδενική αναφορά του CarBrandList (cbl). Αυτό υποδηλώνει ότι το αντικείμενο cbl δεν προετοιμάζεται σωστά πριν το χρησιμοποιήσετε στο SecondActivity.

Ακολουθεί ο προβληματικός κώδικας από το stack trace:
```
Caused by: java.lang.NullPointerException: Attempt to invoke virtual method 'java.util.List gr.uom.carpicker_xml_spiner2radio.CarBrandList.getAllModels(java.lang.String)' on a null object reference
    at gr.uom.carpicker_xml_spiner2radio.SecondActivity.onCreate(SecondActivity.java:34)
```

Το σφάλμα παρουσιάζεται στη γραμμή 34 της SecondActivity. Φαίνεται ότι προσπαθείτε να καλέσετε τη cbl.getAllModels() σε αυτήν τη γραμμή.   

Για να επιλύσετε αυτό το πρόβλημα, βεβαιωθείτε ότι διαβιβάζετε σωστά τις απαιτούμενες πληροφορίες (όπως τη λίστα με τις επωνυμίες) στο SecondActivity. Όταν εκκινείτε το SecondActivity από το MainActivity, θα πρέπει να μεταβιβάσετε τα απαραίτητα δεδομένα χρησιμοποιώντας το Intent. Τροποποιήστε τη μέθοδο sendSecondActivity στο MainActivity σας ως εξής:

```
public void sendSecondActivity(View view) {
    Intent intent = new Intent(this, SecondActivity.class);
    intent.putStringArrayListExtra("BRANDS", cbl.getAllBrands());
    startActivity(intent);
}
```

Στη συνέχεια, στο SecondActivity σας, μπορείτε να ανακτήσετε αυτά τα δεδομένα στη μέθοδο onCreate και να τα χρησιμοποιήσετε για να αρχικοποιήσετε το CarBrandList σας:


```
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_second);

    List<String> brands = getIntent().getStringArrayListExtra("BRANDS");
    cbl = new CarBrandList(getAssets());

    // Τώρα μπορείτε να χρησιμοποιήσετε το αντικείμενο cbl και τη λίστα επωνυμιών 
    //όπως απαιτείται. Για παράδειγμα: Αποκτήστε μοντέλα για την πρώτη μάρκα
    List<String> models = cbl.getAllModels(brands.get(0)); 
    // ...
}
```

Θυμηθείτε να αντικαταστήσετε το "BRANDS" με το κατάλληλο κλειδί που ταιριάζει με αυτό που στέλνετε από το MainActivity.   

Περνώντας τη λίστα των επωνυμιών ως πρόσθετο στο SecondActivity, διασφαλίζετε ότι τα απαραίτητα δεδομένα είναι διαθέσιμα όταν προσπαθείτε να τα χρησιμοποιήσετε στο SecondActivity. Αυτό θα σας βοηθήσει να αποφύγετε το NullPointerException που αντιμετωπίζετε.

## Δηλώσεις εκτύπωσης

Πολύ βοηθητικές είναι και οι  δηλώσεις εκτύπωσης που εμφανίζονται στο Logcat. Μπορείτε να τις βάζετε μετά που κατασκευάζετε μια λίστα ή μια μεταβλητή για να δείτε εάν όντως έχει δημιουργηθεί ή το πρόβλημα πάει σε άλλη κλάση. Η σύνταξη είναι η παρακάτω.

```
Log.d("MainActivity", "Number of items in adapter: " + arrayAdapter.getCount());
```

Βάλτε στην αρχή την κλάση και μετά ένα μήνυμα και τον κώδικα να δείτε εάν φτιάχτηκε.
```
Log.d("MainActivity", "onItemSelected called for position: " + position);
```

Μετά ψάχνετε σε άλλη κλάση
```
Log.d("MultiList", "Number of items in mList: " + mList.size());
```

Και σε άλλη κλάση
```
Log.d("OkHttpHandler", "Server response: " + data);
```


