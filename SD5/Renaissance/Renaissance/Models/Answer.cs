//------------------------------------------------------------------------------
// <auto-generated>
//     This code was generated from a template.
//
//     Manual changes to this file may cause unexpected behavior in your application.
//     Manual changes to this file will be overwritten if the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

namespace Renaissance.Models
{
    using System;
    using System.Collections.Generic;
    
    public partial class Answer
    {
        public int answerId { get; set; }
        public int userId { get; set; }
        public int questionId { get; set; }
        public Nullable<bool> status { get; set; }
    }
}
