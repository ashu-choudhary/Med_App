package com.example.medapp.com.example.medapp.pat_fragment

object DiseaseData {
    val diseaseMap = mapOf(
        "Brain Diseases" to listOf(
            "Alzheimer’s Disease", "Amyotrophic Lateral Sclerosis (ALS)", "Bell’s Palsy", "Brain Tumor", "Cerebral Aneurysm",
            "Cerebral Palsy", "Encephalitis", "Epilepsy", "Guillain-Barré Syndrome", "Headache", "Huntington’s Disease",
            "Hydrocephalus", "Meningitis", "Migraine", "Multiple Sclerosis", "Parkinson’s Disease",
            "Progressive Supranuclear Palsy", "Stroke", "Traumatic Brain Injury (TBI)"
        ),

        "Mental Health Conditions" to listOf(
            "Anxiety Disorders", "Attention-Deficit/Hyperactivity Disorder (ADHD)", "Autism Spectrum Disorder (ASD)",
            "Bipolar Disorder", "Depression", "Schizophrenia"
        ),

        "Eye Diseases" to listOf(
            "Refractive Errors", "Myopia (Nearsightedness)", "Hyperopia (Farsightedness)", "Astigmatism", "Presbyopia",
            "Cataracts", "Glaucoma", "Age-Related Macular Degeneration (AMD)", "Diabetic Retinopathy", "Retinal Detachment",
            "Uveitis", "Conjunctivitis (Pink Eye)", "Blepharitis", "Keratoconus", "Amblyopia (Lazy Eye)", "Strabismus (Squint)",
            "Dry Eye", "Retinitis Pigmentosa", "Color Blindness", "Floaters", "Stye",
            // Eyelid Disorders
            "Blepharospasm", "Chalazion", "Ectropion", "Entropion", "Ptosis", "Dermatochalasis", "Lacrimal Duct Obstruction",
            // Eyelid Infections
            "Conjunctivitis", "Stye",
            // Eyelid Tumors
            "Xanthelasma", "Basal Cell Carcinoma", "Squamous Cell Carcinoma", "Sebaceous Cell Carcinomas",
            "Merkel Cell Carcinomas", "Melanomas", "Lymphomas"
        ),

        "Ear Diseases" to listOf(
            // Infections
            "Otitis Externa", "Otitis Media", "Acute Mastoiditis", "Infectious Myringitis",
            // Hearing Loss
            "Noise-Induced Hearing Loss", "Otosclerosis", "Meniere’s Disease",
            // Other Conditions
            "Acoustic Neuroma", "Labyrinthitis", "Vertigo", "Nystagmus", "Ear Wax", "Glue Ear", "Pendred Syndrome",
            "Sudden Deafness", "Tinnitus", "Usher Syndrome", "Vestibular Schwannoma", "Neurofibromatosis"
        ),

        "Nose Diseases" to listOf(
            "Allergic Rhinitis (Hay Fever)", "Rhinitis", "Chronic Rhinosinusitis", "Sinusitis", "Nasal Vestibulitis",
            "Nonallergic Rhinitis", "Deviated Septum", "Nasal Polyps", "Nasal Fractures", "Nasal Obstruction",
            "Nosebleeds (Epistaxis)", "Cerebrospinal Fluid (CSF) Leak", "Loss of Smell (Anosmia)",
            "Nasal and Sinus Tumors", "Aspirin-Exacerbated Respiratory Disease (AERD)", "Nasal Septal Abscess",
            "Nasal Septal Hematoma", "Nasal Septal Perforation", "Thyroid Eye Disease", "Nasal Deformities",
            "Enlarged Adenoids"
        ),

        "Mouth Diseases" to listOf(
            "Dental Caries (Tooth Decay)", "Gingivitis", "Periodontitis", "Oral Thrush (Candidiasis)",
            "Hand, Foot, and Mouth Disease", "Herpangina", "Oral Herpes", "Mouth Ulcers (Aphthous Stomatitis)",
            "Canker Sores", "Cold Sores (Fever Blisters)", "Lichen Planus", "Burning Mouth Syndrome", "Behcet’s Disease",
            "Sjögren’s Syndrome", "Dry Mouth (Xerostomia)", "Leukoplakia", "Mouth Cancer", "Dysphagia (Difficulty Swallowing)",
            "Bad Breath (Halitosis)", "Dental Erosion", "Oro-Dental Trauma", "Orofacial Clefts", "Noma"
        ),

        "Dental Diseases" to listOf(
            "Tooth Decay (Cavities)", "Gum Disease (Periodontal Disease)", "Gingivitis", "Periodontitis", "Oral Cancer",
            "Tooth Sensitivity", "Chipped or Cracked Teeth", "Toothaches", "Temporomandibular Disorder (TMD)",
            "Impacted Teeth", "Misaligned Teeth (Malocclusion)"
        ),

        "Neck Diseases" to listOf(
            "Cervical Spondylosis", "Degenerative Disc Disease", "Cervical Spinal Stenosis", "Cervical Radiculopathy",
            "Cervical Myelopathy", "Whiplash", "Neck Sprain or Strain", "Herniated Disc", "Cervical Dystonia",
            "Meningitis", "Tumors", "Infections", "Rheumatoid Arthritis", "Osteoarthritis", "Cervicogenic Headache",
            "Klippel-Feil Syndrome", "Syringomyelia"
        ),

        "Chest Diseases" to listOf(
            "Pneumonia", "Bronchitis", "Tuberculosis (TB)", "Chronic Obstructive Pulmonary Disease (COPD)",
            "Emphysema", "Chronic Bronchitis", "Asthma", "Lung Cancer", "Interstitial Lung Diseases (ILD)",
            "Pulmonary Fibrosis", "Bronchiectasis", "Cystic Fibrosis", "Pulmonary Hypertension", "Pneumothorax",
            "Pleural Effusion", "Mesothelioma", "Pulmonary Embolism"
        ),

        "Lung Diseases" to listOf(
            "Bronchitis", "Bronchiectasis", "Emphysema", "Pulmonary Embolism", "Pulmonary Hypertension",
            "Pneumonia", "Pneumothorax", "Asbestosis", "Alpha-1 Antitrypsin Deficiency"
        ),

        "Heart Diseases" to listOf(
            "Acute Coronary Syndrome", "Amyloidosis", "Angina", "Aortic Aneurysm", "Aortic Dissection", "Aortic Stenosis",
            "Arrhythmia", "Atherosclerosis", "Atrial Fibrillation (AF)", "Atrial Flutter (AFL)", "Atrial Septal Defect",
            "Bradycardia", "Broken Heart Syndrome", "Brugada Syndrome", "Cardiac Arrest", "Cardiac Sarcoidosis",
            "Cardiac Tamponade", "Cardiomyopathy", "Cardiogenic Shock", "Chest Pain", "Congenital Heart Disease (CHD)",
            "Coronavirus (COVID-19)", "Coronary Heart Disease", "Diabetes", "Dilated Cardiomyopathy",
            "Ehlers-Danlos Syndrome", "Endocarditis", "Familial Hypercholesterolemia", "Fibromuscular Dysplasia",
            "Heart Attack", "Heart Failure", "Heart Murmur", "Heart Valve Disease", "High Blood Pressure",
            "High Blood Sugar", "High Cholesterol", "Heart Palpitations", "Hypertrophic Cardiomyopathy",
            "Ischaemic Heart Disease", "Kawasaki Disease", "Long QT Syndrome", "Marfan Syndrome", "Menopause",
            "Mental Health (Cardiac)", "Metabolic Syndrome", "Myocarditis", "Obesity", "Pericardial Effusion",
            "Pericarditis", "Peripheral Artery Disease", "Pulmonary Embolism", "Pulmonary Hypertension",
            "Pulmonary Stenosis", "Pregnancy & Heart Conditions", "Rheumatic Heart Disease",
            "Spontaneous Coronary Artery Dissection", "Stroke", "Sudden Cardiac Arrest", "Supraventricular Tachycardia",
            "Tetralogy of Fallot", "Transposition of the Great Arteries", "Ventricular Septal Defect",
            "Women’s Heart Disease"
        ),

        "Stomach Diseases" to listOf(
            "Gastritis", "Gastroenteritis", "Peptic Ulcers", "Gastroesophageal Reflux Disease (GERD)", "Gastroparesis",
            "Dyspepsia (Indigestion)", "Stomach Cancer", "Helicobacter pylori Infection", "Irritable Bowel Syndrome (IBS)",
            "Inflammatory Bowel Disease (IBD)", "Celiac Disease", "Diverticulitis", "Small Intestinal Bacterial Overgrowth (SIBO)",
            "Lactose Intolerance", "Food Poisoning", "Constipation", "Diarrhea", "Gas and Bloating", "Abdominal Pain",
            "Nausea and Vomiting", "Heartburn"
        ),

        "Liver Diseases" to listOf(
            "Hepatitis A", "Hepatitis B", "Hepatitis C", "Hepatitis D", "Hepatitis E", "Fatty Liver Disease", "Cirrhosis",
            "Liver Failure", "Liver Cancer", "Autoimmune Hepatitis", "Primary Biliary Cholangitis (PBC)",
            "Primary Sclerosing Cholangitis (PSC)", "Wilson’s Disease", "Hemochromatosis", "Biliary Atresia",
            "Alagille Syndrome", "Alpha-1 Antitrypsin Deficiency", "Cholangiocarcinoma", "Gilbert’s Syndrome",
            "Metabolic Dysfunction-Associated Steatotic Liver Disease (MASLD)"
        )
    )
}